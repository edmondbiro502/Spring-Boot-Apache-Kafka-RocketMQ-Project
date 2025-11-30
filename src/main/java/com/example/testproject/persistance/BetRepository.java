package com.example.testproject.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByUserId(Long userId);
    List<Bet> findByEventId(String eventId);
}