package com.example.typingbattle.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.typingbattle.model.GameMessage;
import com.example.typingbattle.model.Room;
import com.example.typingbattle.service.RoomService;

@Controller
public class GameController {

    private final RoomService roomService;
    private final SimpMessagingTemplate messagingTemplate;

    public GameController(RoomService roomService, SimpMessagingTemplate messagingTemplate) {
        this.roomService = roomService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/rooms/{code}/join")
    public void join(@DestinationVariable String code, GameMessage message) {
        Room room = roomService.findRoom(code);
        if (room == null) {
            return;
        }

        synchronized (room) {
            room.addPlayer(message.getNickname());

            GameMessage playersMessage = new GameMessage();
            playersMessage.setType("PLAYERS");
            playersMessage.setPlayers(room.getPlayers());
            messagingTemplate.convertAndSend("/topic/rooms/" + code, playersMessage);
        }
    }

    @MessageMapping("/rooms/{code}/start")
    public void start(@DestinationVariable String code, GameMessage message) {
        Room room = roomService.findRoom(code);
        if (room == null) {
            return;
        }

        synchronized (room) {
            if (room.canStart(message.getNickname()) && room.start()) {
                GameMessage countdownMessage = new GameMessage();
                countdownMessage.setType("COUNTDOWN");
                messagingTemplate.convertAndSend("/topic/rooms/" + code, countdownMessage);
            }
        }
    }

    @MessageMapping("/rooms/{code}/progress")
    public void progress(@DestinationVariable String code, GameMessage message) {
        message.setType("PROGRESS");
        messagingTemplate.convertAndSend("/topic/rooms/" + code, message);
    }

    @MessageMapping("/rooms/{code}/finish")
    public void finish(@DestinationVariable String code, GameMessage message) {
        Room room = roomService.findRoom(code);
        if (room == null) {
            return;
        }
        int rank = room.finish(message.getNickname());

        message.setType("FINISH");
        message.setRank(rank);
        message.setElapsedMs(room.getElapsedMs());
        messagingTemplate.convertAndSend("/topic/rooms/" + code, message);
    }
}