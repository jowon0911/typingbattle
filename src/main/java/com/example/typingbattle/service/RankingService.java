package com.example.typingbattle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.typingbattle.entity.PlayerStat;
import com.example.typingbattle.model.PlayerResult;
import com.example.typingbattle.repository.PlayerStatRepository;

@Service
public class RankingService {

    public static final int SCORE_STEP = 10;

    private final PlayerStatRepository playerStatRepository;

    public RankingService(PlayerStatRepository playerStatRepository) {
        this.playerStatRepository = playerStatRepository;
    }

    public static int calculateChange(int playerCount, int rank) {
        return (playerCount + 1 - 2 * rank) * SCORE_STEP;
    }

    @Transactional
    public void applyRankedResults(List<PlayerResult> results) {
        int playerCount = results.size();
        for (PlayerResult result : results) {
            PlayerStat stat = playerStatRepository.findByNickname(result.getNickname()).orElse(null);
            if (stat == null) {
                stat = new PlayerStat(result.getNickname());
            }
            int before = stat.getScore();
            boolean win = result.isFinished() && result.getRank() == 1;
            stat.addResult(calculateChange(playerCount, result.getRank()), win, result.getCpm());
            playerStatRepository.save(stat);

            result.setScoreChange(stat.getScore() - before);
            result.setScore(stat.getScore());
        }
    }

    @Transactional(readOnly = true)
    public List<PlayerStat> getTop20() {
        return playerStatRepository.findTop20ByOrderByScoreDescWinsDesc();
    }

    @Transactional(readOnly = true)
    public List<PlayerStat> getTop5() {
        return playerStatRepository.findTop5ByOrderByScoreDescWinsDesc();
    }
}
