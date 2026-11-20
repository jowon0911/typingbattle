package com.example.typingbattle.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.typingbattle.service.GameService;
import com.example.typingbattle.service.MatchService;

@Component
public class GameScheduler {

    private final MatchService matchService;
    private final GameService gameService;

    public GameScheduler(MatchService matchService, GameService gameService) {
        this.matchService = matchService;
        this.gameService = gameService;
    }

    @Scheduled(fixedRate = 1000)
    public void tick() {
        matchService.makeMatches("NORMAL");
        matchService.makeMatches("RANKED");
        gameService.checkRooms();
    }
}
