package com.chnic.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaGoodbyeServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaGoodbyeServiceProviderApplication.class, args);
	}
}
