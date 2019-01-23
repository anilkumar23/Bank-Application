package com.service.thinkProAccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ThinkProAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkProAccountApplication.class, args);
	}
}
