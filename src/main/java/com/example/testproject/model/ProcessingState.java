package com.example.testproject.model;

public enum ProcessingState {
    PUBLISHED_TO_ROCKETMQ(1),
    FAILED_PUBLISHING_TO_ROCKETMQ(2),
    PUBLISHED_TO_DLQ(3);

    private final int value;

    ProcessingState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}