package com.chnic.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaRibbonConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibbonConsumerApplication.class, args);
	}
}
