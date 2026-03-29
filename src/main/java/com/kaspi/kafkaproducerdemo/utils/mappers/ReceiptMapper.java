package com.kaspi.kafkaproducerdemo.utils.mappers;

import com.kaspi.kafkaproducerdemo.domain.dto.ReceiptDto;
import com.kaspi.kafkaproducerdemo.domain.entities.Receipt;

import java.util.UUID;

public class ReceiptMapper {
    public static Receipt mapDtoToReceipt(ReceiptDto receiptDto) {
        return Receipt.builder()
                .description(receiptDto.description())
                .fileUrl(receiptDto.fileUrl())
                .issuer(receiptDto.issuer())
                .paymentId(receiptDto.paymentId())
                .build();
    }
}
