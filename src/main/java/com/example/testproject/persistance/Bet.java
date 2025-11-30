package com.example.testproject.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Bets")
@Data
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "betId")
    private Long betId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "eventId", nullable = false)
    private String eventId;

    @Column(name = "eventMarketID", nullable = false)
    private Integer eventMarketID;

    @Column(name = "EVENTWINNERID", nullable = false)
    private Integer eventWinnerId;

    @Column(name = "betAmount", nullable = false, precision = 12, scale = 2)
    private java.math.BigDecimal betAmount;
}