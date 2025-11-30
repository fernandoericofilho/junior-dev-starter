package com.kafka.producer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrderMessage(
        @NotBlank String id,
        @NotBlank String productName,
        java.math.BigDecimal amount,
        @NotNull Integer quantity,
        @NotNull LocalDateTime timestamp
) {}
