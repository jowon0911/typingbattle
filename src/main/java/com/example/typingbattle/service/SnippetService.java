package com.example.typingbattle.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.typingbattle.entity.Snippet;
import com.example.typingbattle.repository.SnippetRepository;

@Service
public class SnippetService {

    private final SnippetRepository snippetRepository;
    private final Random random = new Random();

    public SnippetService(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public Snippet pickRandom(String difficulty) {
        List<Snippet> snippets = snippetRepository.findByDifficulty(difficulty);
        if (snippets.isEmpty()) {
            snippets = snippetRepository.findAll();
        }
        int index = random.nextInt(snippets.size());
        return snippets.get(index);
    }
}