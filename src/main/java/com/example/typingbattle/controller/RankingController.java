package com.example.typingbattle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.typingbattle.entity.PlayerStat;
import com.example.typingbattle.service.RankingService;

@Controller
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        model.addAttribute("rankings", rankingService.getTop20());
        model.addAttribute("startScore", PlayerStat.START_SCORE);
        return "ranking";
    }
}
