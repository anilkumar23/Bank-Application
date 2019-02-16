package com.service.thinkProBranch.serviceImpl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "test", groupId = "group.id")
    public void receive(String payload){
        System.out.println(payload);

    }
}
