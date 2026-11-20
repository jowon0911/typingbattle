package com.example.typingbattle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.typingbattle.model.Room;
import com.example.typingbattle.service.MatchService;
import com.example.typingbattle.service.RankingService;
import com.example.typingbattle.service.RoomService;

@Controller
public class RoomController {

    private final RoomService roomService;
    private final RankingService rankingService;

    public RoomController(RoomService roomService, RankingService rankingService) {
        this.roomService = roomService;
        this.rankingService = rankingService;
    }

    @GetMapping("/")
    public String lobby(Model model) {
        model.addAttribute("topRankings", rankingService.getTop5());
        return "lobby";
    }

    @PostMapping("/rooms")
    public String createRoom(@RequestParam String nickname,
                             @RequestParam(defaultValue = "RANDOM") String difficulty,
                             RedirectAttributes redirectAttributes) {
        nickname = nickname.trim();
        if (!MatchService.isValidNickname(nickname)) {
            redirectAttributes.addFlashAttribute("error", "닉네임은 1~10글자로 입력해 주세요.");
            return "redirect:/";
        }
        Room room = roomService.createRoom(difficulty, "NORMAL", false);
        redirectAttributes.addAttribute("nickname", nickname);
        return "redirect:/rooms/" + room.getCode();
    }

    @GetMapping("/rooms/join")
    public String joinRoom(@RequestParam String code, @RequestParam String nickname,
                           RedirectAttributes redirectAttributes) {
        nickname = nickname.trim();
        Room room = roomService.findRoom(code.trim());
        if (!MatchService.isValidNickname(nickname)) {
            redirectAttributes.addFlashAttribute("error", "닉네임은 1~10글자로 입력해 주세요.");
            return "redirect:/";
        }
        if (room == null) {
            redirectAttributes.addFlashAttribute("error", "방을 찾을 수 없어요. 방 코드를 확인해 주세요.");
            return "redirect:/";
        }
        if (room.isMatched()) {
            redirectAttributes.addFlashAttribute("error", "랜덤 매칭 방에는 코드로 들어갈 수 없어요.");
            return "redirect:/";
        }
        if (room.hasPlayer(nickname)) {
            redirectAttributes.addFlashAttribute("error", "방에 같은 닉네임이 있어요. 다른 닉네임을 써 주세요.");
            return "redirect:/";
        }
        if (room.isStarted()) {
            redirectAttributes.addFlashAttribute("error", "이미 게임이 시작된 방이에요.");
            return "redirect:/";
        }
        if (room.isFull()) {
            redirectAttributes.addFlashAttribute("error", "방이 꽉 찼어요. (최대 " + Room.MAX_PLAYERS + "명)");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("nickname", nickname);
        return "redirect:/rooms/" + room.getCode();
    }

    @GetMapping("/rooms/{code}")
    public String battle(@PathVariable String code, @RequestParam String nickname,
                         Model model, RedirectAttributes redirectAttributes) {
        Room room = roomService.findRoom(code);
        if (room == null) {
            redirectAttributes.addFlashAttribute("error", "방이 없어졌어요. 다시 시작해 주세요.");
            return "redirect:/";
        }
        if (room.isMatched() && !room.isReserved(nickname)) {
            redirectAttributes.addFlashAttribute("error", "매칭된 사람만 들어갈 수 있는 방이에요.");
            return "redirect:/";
        }
        if (room.isStarted() && !room.isActivePlayer(nickname)) {
            redirectAttributes.addFlashAttribute("error", "이미 게임이 시작된 방이에요.");
            return "redirect:/";
        }
        model.addAttribute("room", room);
        model.addAttribute("nickname", nickname);
        model.addAttribute("maxPlayers", Room.MAX_PLAYERS);
        model.addAttribute("timeLimitSec", Room.TIME_LIMIT_MS / 1000);
        return "battle";
    }
}
