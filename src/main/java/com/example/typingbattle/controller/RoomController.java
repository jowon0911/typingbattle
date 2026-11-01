package com.example.typingbattle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.typingbattle.model.Room;
import com.example.typingbattle.service.RoomService;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public String lobby() {
        return "lobby";
    }

    @PostMapping("/rooms")
    public String createRoom(@RequestParam String nickname, RedirectAttributes redirectAttributes) {
        Room room = roomService.createRoom();
        redirectAttributes.addAttribute("nickname", nickname);
        return "redirect:/rooms/" + room.getCode();
    }

    @GetMapping("/rooms/join")
    public String joinRoom(@RequestParam String code, @RequestParam String nickname,
                           RedirectAttributes redirectAttributes) {
        Room room = roomService.findRoom(code);
        if (room == null) {
            redirectAttributes.addFlashAttribute("error", "방을 찾을 수 없어요. 방 코드를 확인해 주세요.");
            return "redirect:/";
        }
        if (room.hasPlayer(nickname)) {
            redirectAttributes.addFlashAttribute("error", "방에 같은 닉네임이 있어요. 다른 닉네임을 써 주세요.");
            return "redirect:/";
        }
        if (room.isFull()) {
            redirectAttributes.addFlashAttribute("error", "방이 꽉 찼어요.");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("nickname", nickname);
        return "redirect:/rooms/" + code;
    }

    // 대결 화면
    @GetMapping("/rooms/{code}")
    public String battle(@PathVariable String code, @RequestParam String nickname, Model model) {
        Room room = roomService.findRoom(code);
        if (room == null) {
            return "redirect:/";
        }
        model.addAttribute("room", room);
        model.addAttribute("nickname", nickname);
        return "battle";
    }
}