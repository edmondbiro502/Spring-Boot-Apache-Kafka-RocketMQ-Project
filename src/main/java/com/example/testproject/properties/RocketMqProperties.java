package com.example.testproject.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.rocketmq")
public class RocketMqProperties {
    private String nameServer;
    private String producerGroup;
    private Integer messageTimeout;
}