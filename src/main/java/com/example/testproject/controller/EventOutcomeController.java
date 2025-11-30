package com.example.testproject.controller;

import com.example.testproject.model.EventOutcome;
import com.example.testproject.model.EventOutcomeProcessingResult;
import com.example.testproject.model.ProcessingState;
import com.example.testproject.service.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sportEvents")
public class EventOutcomeController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/publishOutcome")
    public ResponseEntity<EventOutcomeProcessingResult> publishOutcome(@RequestBody EventOutcome outcomeEvent) {
        kafkaProducerService.sendOutcome(outcomeEvent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createSuccessResponse(outcomeEvent));
    }

    private EventOutcomeProcessingResult createSuccessResponse(final EventOutcome outcomeEvent) {
        return EventOutcomeProcessingResult.builder()
                .eventId(outcomeEvent.eventId())
                .processingState(ProcessingState.PUBLISHED_TO_ROCKETMQ)
                .timestamp(LocalDateTime.now())
                .build();
    }
}

