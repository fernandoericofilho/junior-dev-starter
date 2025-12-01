package com.kafka.producer.service;

import com.kafka.producer.dto.OrderMessage;
import com.kafka.producer.dto.UserMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserMessage(UserMessage userMessage) {
        String key = UUID.randomUUID().toString();
        CompletableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send("user-topic", key, userMessage);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info("User message sent successfully: {} - Offset: {}",
                        userMessage.id(), result.getRecordMetadata().offset());
            } else {
                logger.error("Failed to send user message: {}", userMessage.id(), ex);
            }
        });
    }

    public void sendOrderMessage(OrderMessage orderMessage) {
        String key = UUID.randomUUID().toString();
        CompletableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send("order-topic", key, orderMessage);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info("Order message sent successfully: {} - Offset: {}",
                        orderMessage.id(), result.getRecordMetadata().offset());
            } else {
                logger.error("Failed to send order message: {}", orderMessage.id(), ex);
            }
        });
    }

    public UserMessage generateSampleUser() {
        return new UserMessage(
                UUID.randomUUID().toString(),
                "User " + System.currentTimeMillis(),
                "user" + System.currentTimeMillis() + "@example.com",
                LocalDateTime.now()
        );
    }

    public OrderMessage generateSampleOrder() {
        return new OrderMessage(
                UUID.randomUUID().toString(),
                "Product " + System.currentTimeMillis(),
                new BigDecimal("99.99"),
                2,
                LocalDateTime.now()
        );
    }
}