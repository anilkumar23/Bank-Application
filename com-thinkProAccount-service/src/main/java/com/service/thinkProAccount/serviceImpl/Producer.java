package com.service.thinkProAccount.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.service.thinkProAccount.domain.Account;

/**
 * Created by anil.saladi on 12/19/2018.
 */
@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, Account> kafkaTemplate;

	@Value("test")
	String kafkaTopic;

	public void send(Account payload) {
		System.out.println("sending " + payload + " to " + kafkaTopic);
		kafkaTemplate.send(kafkaTopic, payload);

	}
}
