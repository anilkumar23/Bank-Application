package com.service.thinkProBranch.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.service.thinkProBranch.domain.Branch;

/**
 * Created by anil.saladi on 12/19/2018.
 */
@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, Branch> kafkaTemplate;

    @Value("test")
    String kafkaTopic;

    public void send(Branch payload){
        System.out.println("sending " + payload + " to " + kafkaTopic);
        kafkaTemplate.send(kafkaTopic, payload);

    }
}

