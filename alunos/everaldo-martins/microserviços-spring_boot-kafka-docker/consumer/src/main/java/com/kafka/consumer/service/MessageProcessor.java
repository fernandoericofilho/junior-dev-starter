package com.kafka.consumer.service;

import com.kafka.consumer.dto.OrderMessage;
import com.kafka.consumer.dto.UserMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MessageProcessor.class);
    
    private final ConcurrentMap<String, UserMessage> userMessages = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, OrderMessage> orderMessages = new ConcurrentHashMap<>();
    private final AtomicLong userCounter = new AtomicLong();
    private final AtomicLong orderCounter = new AtomicLong();

    @KafkaListener(topics = "user-topic", groupId = "consumer-group")
    public void consumeUserMessages(
            @Payload List<UserMessage> messages,
            @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
            Acknowledgment ack) {
        
        logger.info("Received {} user messages", messages.size());
        
        for (int i = 0; i < messages.size(); i++) {
            UserMessage message = messages.get(i);
            String key = keys.get(i);
            
            userMessages.put(key, message);
            userCounter.incrementAndGet();
            
            logger.info("Processed user message - ID: {}, Name: {}, Email: {}", 
                message.id(), message.name(), message.email());
        }
        
        ack.acknowledge();
    }

    @KafkaListener(topics = "order-topic", groupId = "consumer-group")
    public void consumeOrderMessages(
            @Payload List<OrderMessage> messages,
            @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
            Acknowledgment ack) {
        
        logger.info("Received {} order messages", messages.size());
        
        for (int i = 0; i < messages.size(); i++) {
            OrderMessage message = messages.get(i);
            String key = keys.get(i);
            
            orderMessages.put(key, message);
            orderCounter.incrementAndGet();
            
            logger.info("Processed order message - ID: {}, Product: {}, Amount: {}", 
                message.id(), message.productName(), message.amount());
        }
        
        ack.acknowledge();
    }

    public ConcurrentMap<String, UserMessage> getUserMessages() {
        return new ConcurrentHashMap<>(userMessages);
    }

    public ConcurrentMap<String, OrderMessage> getOrderMessages() {
        return new ConcurrentHashMap<>(orderMessages);
    }

    public long getUserCount() {
        return userCounter.get();
    }

    public long getOrderCount() {
        return orderCounter.get();
    }
}