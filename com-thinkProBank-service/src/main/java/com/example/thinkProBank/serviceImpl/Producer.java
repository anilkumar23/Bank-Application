package com.example.thinkProBank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.thinkProBank.domain.Bank;
import com.example.thinkProBank.domain.Branch;

/**
 * Created by anil.saladi on 12/19/2018.
 */
@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    /*
    @Autowired
    private KafkaTemplate<String, Branch> kafkaTemplate1;*/

    @Value("test")
    String kafkaTopic;

    public void send(Bank payload){
        System.out.println("sending " + payload + " to " + kafkaTopic);
        kafkaTemplate.send(kafkaTopic, payload);

    }

    public void sendBranch(Branch payload){
        System.out.println("sending " + payload + " to " + kafkaTopic);
        kafkaTemplate.send(kafkaTopic, payload);

    }
    
   /* public void send(Branch payload){
        System.out.println("sending " + payload + " to " + kafkaTopic);
        kafkaTemplate1.send(kafkaTopic, payload);

    }*/
}

