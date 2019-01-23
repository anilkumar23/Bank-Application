package com.service.thinkProBranch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComThinkProBranchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComThinkProBranchServiceApplication.class, args);
	}
}
