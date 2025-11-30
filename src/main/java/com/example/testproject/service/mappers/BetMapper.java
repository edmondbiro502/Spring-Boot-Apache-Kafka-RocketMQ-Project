package com.example.testproject.service.mappers;

import com.example.testproject.model.BetSettlementEvent;
import com.example.testproject.persistance.Bet;

public class BetMapper {
    public static BetSettlementEvent toSettlementEvent(Bet bet) {
        return new BetSettlementEvent(
            bet.getBetId(),
            bet.getUserId(),
            bet.getEventId(),
            bet.getEventMarketID(),
            bet.getEventWinnerId(),
            bet.getBetAmount()
        );
    }

}
