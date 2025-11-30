package com.example.testproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BetSettlementEvent {
    private Long betId;
    private Long userId;
    private String eventId;
    private String eventMarketID;
    private String eventWinnerId;
    private BigDecimal betAmount;
}