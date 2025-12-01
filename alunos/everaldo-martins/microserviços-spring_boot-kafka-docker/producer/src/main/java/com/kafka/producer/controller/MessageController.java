package com.kafka.producer.controller;

import com.kafka.producer.dto.OrderMessage;
import com.kafka.producer.dto.UserMessage;
import com.kafka.producer.service.KafkaProducerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaProducerService kafkaProducerService;

    public MessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> sendUserMessage(@Valid @RequestBody UserMessage userMessage) {
        kafkaProducerService.sendUserMessage(userMessage);
        Map<String, String> response = new HashMap<>();
        response.put("status", "User message sent successfully");
        response.put("id", userMessage.id());
        response.put("timestamp", userMessage.timestamp().toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/order")
    public ResponseEntity<Map<String, String>> sendOrderMessage(@Valid @RequestBody OrderMessage orderMessage) {
        kafkaProducerService.sendOrderMessage(orderMessage);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Order message sent successfully");
        response.put("id", orderMessage.id());
        response.put("product", orderMessage.productName());
        response.put("timestamp", orderMessage.timestamp().toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sample/user")
    public ResponseEntity<Map<String, String>> sendSampleUser() {
        UserMessage sampleUser = kafkaProducerService.generateSampleUser();
        kafkaProducerService.sendUserMessage(sampleUser);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Sample user message sent successfully");
        response.put("id", sampleUser.id());
        response.put("name", sampleUser.name());
        response.put("email", sampleUser.email());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sample/order")
    public ResponseEntity<Map<String, String>> sendSampleOrder() {
        OrderMessage sampleOrder = kafkaProducerService.generateSampleOrder();
        kafkaProducerService.sendOrderMessage(sampleOrder);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Sample order message sent successfully");
        response.put("id", sampleOrder.id());
        response.put("product", sampleOrder.productName());
        response.put("amount", sampleOrder.amount().toString());
        response.put("quantity", sampleOrder.quantity().toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "Producer API");
        response.put("timestamp", java.time.LocalDateTime.now().toString());
        return ResponseEntity.ok(response);
    }
}