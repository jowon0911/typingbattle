package com.example.typingbattle.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.typingbattle.model.GameMessage;
import com.example.typingbattle.service.GameService;

@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/rooms/{code}/join")
    public void join(@DestinationVariable String code, GameMessage message,
                     SimpMessageHeaderAccessor headerAccessor) {
        gameService.join(code, message.getNickname(), headerAccessor.getSessionId());
    }

    @MessageMapping("/rooms/{code}/start")
    public void start(@DestinationVariable String code, SimpMessageHeaderAccessor headerAccessor) {
        gameService.start(code, headerAccessor.getSessionId());
    }

    @MessageMapping("/rooms/{code}/host")
    public void changeHost(@DestinationVariable String code, GameMessage message,
                           SimpMessageHeaderAccessor headerAccessor) {
        gameService.changeHost(code, headerAccessor.getSessionId(), message.getTarget());
    }

    @MessageMapping("/rooms/{code}/bot/add")
    public void addBot(@DestinationVariable String code, GameMessage message,
                       SimpMessageHeaderAccessor headerAccessor) {
        gameService.addBot(code, headerAccessor.getSessionId(), message.getLevel());
    }

    @MessageMapping("/rooms/{code}/bot/remove")
    public void removeBot(@DestinationVariable String code, GameMessage message,
                          SimpMessageHeaderAccessor headerAccessor) {
        gameService.removeBot(code, headerAccessor.getSessionId(), message.getTarget());
    }

    @MessageMapping("/rooms/{code}/progress")
    public void progress(@DestinationVariable String code, GameMessage message,
                         SimpMessageHeaderAccessor headerAccessor) {
        gameService.progress(code, headerAccessor.getSessionId(), message.getProgress());
    }

    @MessageMapping("/rooms/{code}/finish")
    public void finish(@DestinationVariable String code, GameMessage message,
                       SimpMessageHeaderAccessor headerAccessor) {
        gameService.finish(code, headerAccessor.getSessionId(), message.getCpm(), message.getAccuracy());
    }
}
