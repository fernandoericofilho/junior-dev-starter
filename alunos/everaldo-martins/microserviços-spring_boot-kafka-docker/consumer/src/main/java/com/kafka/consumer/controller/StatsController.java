package com.kafka.consumer.controller;

import com.kafka.consumer.dto.OrderMessage;
import com.kafka.consumer.dto.UserMessage;
import com.kafka.consumer.service.MessageProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final MessageProcessor messageProcessor;

    public StatsController(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getUserStats() {
        ConcurrentMap<String, UserMessage> users = messageProcessor.getUserMessages();
        long count = messageProcessor.getUserCount();
        
        return ResponseEntity.ok(Map.of(
            "totalProcessed", count,
            "currentInMemory", users.size(),
            "users", users
        ));
    }

    @GetMapping("/orders")
    public ResponseEntity<Map<String, Object>> getOrderStats() {
        ConcurrentMap<String, OrderMessage> orders = messageProcessor.getOrderMessages();
        long count = messageProcessor.getOrderCount();
        
        return ResponseEntity.ok(Map.of(
            "totalProcessed", count,
            "currentInMemory", orders.size(),
            "orders", orders
        ));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "Consumer API is healthy"));
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary() {
        return ResponseEntity.ok(Map.of(
            "userMessages", messageProcessor.getUserCount(),
            "orderMessages", messageProcessor.getOrderCount(),
            "memoryUsers", messageProcessor.getUserMessages().size(),
            "memoryOrders", messageProcessor.getOrderMessages().size()
        ));
    }
}