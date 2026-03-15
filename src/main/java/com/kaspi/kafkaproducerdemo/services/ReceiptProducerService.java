package com.kaspi.kafkaproducerdemo.services;

import com.kaspi.kafkaproducerdemo.domain.entities.Receipt;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiptProducerService {
    private final KafkaTemplate<String, Receipt> kafkaTemplate;

    /**
     * Sends a {@link Receipt} message to the "receipts" Kafka topic.
     *
     * @param receipt the {@link Receipt} object to be sent to Kafka
     */
    public void sendReceiptToTopic(Receipt receipt) {
        kafkaTemplate.executeInTransaction(kafkaTemplate -> {
            kafkaTemplate.send("receipts", String.valueOf(receipt.getReceiptNumber()), receipt);
            return new Object();
        });
    }
}
