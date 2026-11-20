package com.example.typingbattle.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.typingbattle.service.GameService;
import com.example.typingbattle.service.MatchService;

@Component
public class DisconnectListener {

    private final MatchService matchService;
    private final GameService gameService;

    public DisconnectListener(MatchService matchService, GameService gameService) {
        this.matchService = matchService;
        this.gameService = gameService;
    }

    @EventListener
    public void onDisconnect(SessionDisconnectEvent event) {
        matchService.cancel(event.getSessionId());
        gameService.leave(event.getSessionId());
    }
}
