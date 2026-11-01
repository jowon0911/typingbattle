package com.example.typingbattle.repository;

import com.example.typingbattle.entity.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepository extends JpaRepository<Snippet, Long> {
}
