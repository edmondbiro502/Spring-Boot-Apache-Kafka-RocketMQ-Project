package com.example.testproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BetSettlementEvent {
    private Long betId;
    private Long userId;
    private String eventId;
    private Integer eventMarketID;
    private Integer eventWinnerId;
    private java.math.BigDecimal betAmount;
}