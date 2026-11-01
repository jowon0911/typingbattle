package com.example.typingbattle.service;

import com.example.typingbattle.entity.Snippet;
import com.example.typingbattle.repository.SnippetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SnippetService {

    private final SnippetRepository snippetRepository;
    private final Random random = new Random();

    public SnippetService(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public Snippet pickRandom() {
        List<Snippet> snippets = snippetRepository.findAll();
        int index = random.nextInt(snippets.size());
        return snippets.get(index);
    }
}
