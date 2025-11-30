package com.example.testproject.service.kafka;

import com.example.testproject.model.EventOutcome;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, EventOutcome> kafkaTemplate;

    public void sendOutcome(final EventOutcome outcome) {
        kafkaTemplate.send("event-outcomes", outcome);
    }
}

