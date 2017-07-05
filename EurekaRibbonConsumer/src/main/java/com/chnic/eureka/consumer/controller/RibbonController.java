package com.chnic.eureka.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
	
	private static final Logger logger = LoggerFactory.getLogger(RibbonController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/ribbon-hello")
	public String sayHello(@RequestParam(name = "title") String title, @RequestParam(name = "name") String name) {
		String url = "http://hello-service/hello?title=" + title + "&name=" + name;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		logger.info("response code: " + responseEntity.getStatusCode().value());
		return responseEntity.getBody();
	}
}
