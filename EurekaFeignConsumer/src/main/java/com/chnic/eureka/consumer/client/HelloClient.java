package com.chnic.eureka.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hello-service", url = "${feign.url}", fallback = HelloClientHystrix.class)
public interface HelloClient {

	@GetMapping(value = "/hello")
	String sayHello(@RequestParam(name = "title") String title, @RequestParam(name = "name") String name);
}
