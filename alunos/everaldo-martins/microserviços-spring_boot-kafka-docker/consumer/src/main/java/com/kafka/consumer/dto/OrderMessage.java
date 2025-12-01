package com.kafka.consumer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderMessage(
        @NotBlank String id,
        @NotBlank String productName,
        @NotNull BigDecimal amount,
        @NotNull Integer quantity,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        @NotNull LocalDateTime timestamp
) {}