package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionListener {

    @Value("${general.kafka-topic}")
    private String topic;

    @KafkaListener(
            topics = "#{__listener.topic}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void receive(Transaction transaction) {
        System.out.println("Received Transaction: " + transaction);
        // No further processing required for Task Two
    }
}

