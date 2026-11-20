package com.example.typingbattle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.typingbattle.entity.PlayerStat;

public interface PlayerStatRepository extends JpaRepository<PlayerStat, Long> {

    Optional<PlayerStat> findByNickname(String nickname);

    List<PlayerStat> findTop20ByOrderByScoreDescWinsDesc();

    List<PlayerStat> findTop5ByOrderByScoreDescWinsDesc();
}
