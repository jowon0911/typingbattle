package com.example.typingbattle.controller;

import com.example.typingbattle.service.SnippetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {

    private final SnippetService snippetService;

    public PracticeController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @GetMapping("/practice")
    public String practice(Model model) {
        model.addAttribute("snippet", snippetService.pickRandom());
        return "practice";
    }
}
