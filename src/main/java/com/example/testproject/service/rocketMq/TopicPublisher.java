package com.example.testproject.service.rocketMq;

import com.example.testproject.exception.BetSettlementPublishingException;
import com.example.testproject.model.BetSettlementEvent;

public interface TopicPublisher {
    void publishBetSettlement(BetSettlementEvent message) throws BetSettlementPublishingException;
}
