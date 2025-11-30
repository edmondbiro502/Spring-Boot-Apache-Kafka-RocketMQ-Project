package com.example.testproject.service.bets;

import com.example.testproject.persistance.Bet;

import java.util.List;

public interface BetService {
    List<Bet> getBetsByEventId(String eventId);
    List<Bet> getBetsByUserId(Long userId);
    List<Bet> getAllBets();
}
