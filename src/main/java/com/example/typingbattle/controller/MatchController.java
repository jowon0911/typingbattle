package com.example.typingbattle.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.typingbattle.model.GameMessage;
import com.example.typingbattle.service.MatchService;

@Controller
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/match")
    public String match(@RequestParam String nickname,
                        @RequestParam(defaultValue = "NORMAL") String mode,
                        Model model, RedirectAttributes redirectAttributes) {
        nickname = nickname.trim();
        if (!MatchService.isValidNickname(nickname)) {
            redirectAttributes.addFlashAttribute("error", "닉네임은 1~10글자로 입력해 주세요.");
            return "redirect:/";
        }
        if (!MatchService.isValidMode(mode)) {
            mode = "NORMAL";
        }

        model.addAttribute("nickname", nickname);
        model.addAttribute("mode", mode);
        model.addAttribute("modeLabel", "RANKED".equals(mode) ? "경쟁전" : "일반전");
        return "match";
    }

    @MessageMapping("/match/join")
    public void join(GameMessage message, SimpMessageHeaderAccessor headerAccessor) {
        matchService.join(message.getNickname(), message.getTicket(),
                headerAccessor.getSessionId(), message.getMode());
    }

    @MessageMapping("/match/cancel")
    public void cancel(SimpMessageHeaderAccessor headerAccessor) {
        matchService.cancel(headerAccessor.getSessionId());
    }
}
