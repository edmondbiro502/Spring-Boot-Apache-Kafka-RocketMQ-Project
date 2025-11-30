package com.example.testproject.controller;

import com.example.testproject.exception.EventOutcomeException;
import com.example.testproject.model.EventOutcomeFailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class EventOutcomeControllerAdvice {

    @ExceptionHandler(EventOutcomeException.class)
    public ResponseEntity<EventOutcomeFailureResponse> handleException(EventOutcomeException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(createFailureResponse(exception));
    }

    private EventOutcomeFailureResponse createFailureResponse(EventOutcomeException ex) {
        return EventOutcomeFailureResponse.builder()
                .eventId(ex.getEventId())
                .processingState(ex.getProcessingState())
                .timestamp(LocalDateTime.now())
                .failureReason(ex.getFailureReason())
                .build();
    }

}