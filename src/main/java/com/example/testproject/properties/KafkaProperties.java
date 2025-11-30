package com.example.testproject.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {
    private String bootstrapServers;
    private Consumer consumer;

    @Data
    @ConfigurationProperties(prefix = "consumer")
    public static class Consumer {
        private String groupId;
        private String autoOffsetReset;
    }
}