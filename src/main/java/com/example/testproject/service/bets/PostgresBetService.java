package com.example.testproject.service.bets;

import com.example.testproject.exception.PersistenceLayerException;
import com.example.testproject.persistance.Bet;
import com.example.testproject.persistance.BetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostgresBetService implements BetService {
    private final BetRepository betRepository;

    public PostgresBetService(final BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public List<Bet> getBetsByUserId(final Long userId) {
        return handleRepositoryCall(() -> betRepository.findByUserId(userId));
    }

    public List<Bet> getAllBets() {
        return handleRepositoryCall(betRepository::findAll);
    }

    public List<Bet> getBetsByEventId(final String eventId) {
        return handleRepositoryCall(() -> betRepository.findByEventId(eventId));
    }

    private <T> T handleRepositoryCall(java.util.concurrent.Callable<T> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new PersistenceLayerException(e);
        }
    }
}