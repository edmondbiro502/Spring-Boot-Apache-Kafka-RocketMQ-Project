package com.example.testproject.service.kafka;

import com.example.testproject.exception.BetSettlementPublishingException;
import com.example.testproject.model.BetSettlementEvent;
import com.example.testproject.model.EventOutcome;
import com.example.testproject.service.bets.BetService;
import com.example.testproject.service.mappers.BetMapper;
import com.example.testproject.service.rocketMq.TopicPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final BetService betService;
    private final TopicPublisher topicPublisher;

    @KafkaListener(topics = "event-outcomes")
    public void listen(EventOutcome eventOutcome) {
        betService.getBetsByEventId(eventOutcome.eventId()).forEach(bet -> {
            final BetSettlementEvent betSettlementEvent = BetMapper.toSettlementEvent(bet);
            try {
                //Potential upgrade: use an executor pool to distribute load across multiple threads
                topicPublisher.publishBetSettlement(betSettlementEvent);
            } catch (BetSettlementPublishingException e) {
                log.error("Failed to publish bet settlement event for bet id {}: {}", bet.getBetId(), e.getMessage());
                /*
                 With default consumer container settings, an exception thrown here will cause the message to be retried.

                 In a high throughput system, batch processing would be a better solution, which would require a dead-letter
                 queue publishing implemented in case of failure.
                 */
            }
        });
    }
}
