package com.example.typingbattle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Snippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    @Column(length = 2000)
    private String content;

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getContent() {
        return content;
    }
}
