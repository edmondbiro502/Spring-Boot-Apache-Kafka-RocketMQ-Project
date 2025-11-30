package com.example.testproject.config;

import com.example.testproject.properties.RocketMqProperties;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RockerMqConfig {

    @Bean
    public DefaultMQProducer defaultMQProducer(RocketMqProperties rocketMqProperties) {
        DefaultMQProducer producer = new DefaultMQProducer(rocketMqProperties.getProducerGroup());
        producer.setNamesrvAddr(rocketMqProperties.getNameServer());
        producer.setSendMsgTimeout(rocketMqProperties.getMessageTimeout());
        return producer;
    }

    @Bean
    public RocketMQTemplate rocketMQTemplate(DefaultMQProducer defaultMQProducer) {
        RocketMQTemplate template = new RocketMQTemplate();
        template.setMessageConverter(new RocketMQMessageConverter().getMessageConverter());
        template.setProducer(defaultMQProducer);
        return template;
    }
}
