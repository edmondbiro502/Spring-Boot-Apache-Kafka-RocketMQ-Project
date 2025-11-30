package com.example.testproject.exception;

import com.example.testproject.model.ProcessingState;
import lombok.Getter;

@Getter
public class EventOutcomeException extends RuntimeException {
    private final String eventId;
    private final String failureReason;
    private final ProcessingState processingState;

    public EventOutcomeException(String eventId, String failureReason, ProcessingState processingState, String message) {
        super(failureReason);
        this.eventId = eventId;
        this.failureReason = failureReason;
        this.processingState = processingState;
    }
}
