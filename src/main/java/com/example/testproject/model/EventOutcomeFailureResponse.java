package com.example.testproject.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class EventOutcomeFailureResponse extends EventOutcomeProcessingResult {
    private final String failureReason;
}
