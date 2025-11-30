package com.example.testproject.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class EventOutcomeProcessingResult {
    private String eventId;
    private LocalDateTime timestamp;
    private ProcessingState processingState;
}