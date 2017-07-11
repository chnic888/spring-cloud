package com.chnic.eureka.consumer.configuration;

import org.springframework.stereotype.Component;

import com.chnic.eureka.consumer.client.HelloClientFallback;

import feign.hystrix.FallbackFactory;

@Component
public class HelloServiceClientFallbackFactory implements FallbackFactory<HelloClientFallback> {

	@Override
	public HelloClientFallback create(Throwable cause) {
		return new HelloClientFallback();
	}
}
