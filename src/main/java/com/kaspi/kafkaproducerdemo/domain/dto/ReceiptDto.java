package com.kaspi.kafkaproducerdemo.domain.dto;

public record ReceiptDto(
         String description,
         String fileUrl,
         String issuer,
         Long paymentId
) {}
