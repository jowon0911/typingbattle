package com.example.typingbattle.service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.typingbattle.model.Room;

@Service
public class RoomService {


    private final Map<String, Room> rooms = new ConcurrentHashMap<>();

    private final SnippetService snippetService;
    private final Random random = new Random();

    public RoomService(SnippetService snippetService) {
        this.snippetService = snippetService;
    }


    public Room createRoom() {
        String code;
        do {
            code = String.valueOf(1000 + random.nextInt(9000));
        } while (rooms.containsKey(code));

        Room room = new Room(code, snippetService.pickRandom());
        rooms.put(code, room);
        return room;
    }

    // 방 코드로 방을 찾는다. 없으면 null
    public Room findRoom(String code) {
        return rooms.get(code);
    }
}