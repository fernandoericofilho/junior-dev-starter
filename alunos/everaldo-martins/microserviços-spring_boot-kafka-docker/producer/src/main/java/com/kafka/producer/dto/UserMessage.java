package com.kafka.producer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record UserMessage(
        @NotBlank String id,
        @NotBlank String name,
        @Email String email,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        @NotNull LocalDateTime timestamp
) {}
