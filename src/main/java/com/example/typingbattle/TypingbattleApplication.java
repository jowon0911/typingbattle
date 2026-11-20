package com.example.typingbattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TypingbattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypingbattleApplication.class, args);
	}

}
