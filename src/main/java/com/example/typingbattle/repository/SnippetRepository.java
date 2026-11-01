package com.example.typingbattle.repository;

import java.util.List;

import com.example.typingbattle.entity.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepository extends JpaRepository<Snippet, Long> {

    List<Snippet> findByDifficulty(String difficulty);
}