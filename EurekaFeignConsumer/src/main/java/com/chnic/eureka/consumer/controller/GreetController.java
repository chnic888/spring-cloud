package com.chnic.eureka.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chnic.eureka.consumer.client.HelloClient;
import com.chnic.eureka.consumer.exception.BadFormatException;

@RestController
public class GreetController {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetController.class);
	
	@Autowired
	private HelloClient helloClient;
	
	@GetMapping(value = "/greet/{user_name}")
	public String greet(@PathVariable("user_name") String userName, @RequestParam(name = "title") String title) {
		String geetingWords = null;
		try {
			geetingWords = helloClient.sayHello(title, userName);
		} catch (BadFormatException e) {
			geetingWords = "Bad format";
			logger.error("Bad format...");
		}
		
		return geetingWords.toUpperCase();
	}
}
