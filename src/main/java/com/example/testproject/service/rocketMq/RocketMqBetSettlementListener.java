package com.example.testproject.service.rocketMq;

import com.example.testproject.model.BetSettlementEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(
    topic = "bet-settlements",
    consumerGroup = "sport-events-rocketmq-consumer-group"
)
public class RocketMqBetSettlementListener implements RocketMQListener<BetSettlementEvent> {

    @Override
    public void onMessage(BetSettlementEvent betSettlementEvent) {
        log.info("Received BetSettlementEvent: {}", betSettlementEvent);
        //Add additional settlement logic...
    }
}

