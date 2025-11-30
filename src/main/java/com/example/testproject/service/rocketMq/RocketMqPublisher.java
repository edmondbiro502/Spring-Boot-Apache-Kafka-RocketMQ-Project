package com.example.testproject.service.rocketMq;

import com.example.testproject.exception.BetSettlementPublishingException;
import com.example.testproject.model.BetSettlementEvent;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RocketMqPublisher implements TopicPublisher {

    private final RocketMQTemplate rocketMQTemplate;
    private static final String BET_SETTLEMENTS = "bet-settlements";

    public void publishBetSettlement(BetSettlementEvent message) throws BetSettlementPublishingException {
        try {
            rocketMQTemplate.convertAndSend(BET_SETTLEMENTS, message);
        } catch (Exception e) {
            throw new BetSettlementPublishingException("Failed to publish bet settlement event to RocketMq: " + e.getMessage(), e);
        }
    }
}
