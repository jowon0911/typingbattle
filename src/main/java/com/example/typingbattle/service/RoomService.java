package com.example.typingbattle.service;

import java.util.ArrayList;
import java.util.List;
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

    public synchronized Room createRoom(String difficulty, String mode, boolean matched) {
        String code;
        do {
            code = String.valueOf(1000 + random.nextInt(9000));
        } while (rooms.containsKey(code));

        Room room = new Room(code, snippetService.pickRandom(difficulty), mode, matched);
        rooms.put(code, room);
        return room;
    }

    public Room findRoom(String code) {
        if (code == null) {
            return null;
        }
        return rooms.get(code);
    }

    public void removeRoom(String code) {
        rooms.remove(code);
    }

    public List<Room> getRooms() {
        return new ArrayList<>(rooms.values());
    }
}
