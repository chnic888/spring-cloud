package com.chnic.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chnic.eureka.consumer.client.HelloClient;

@RestController
public class GreetController {

	@Autowired
	private HelloClient helloClient;
	
	@GetMapping(value = "/greet/{user_name}")
	public String greet(@PathVariable("user_name") String userName, @RequestParam(name = "title") String title) {
		String geetingWords = helloClient.sayHello(title, userName);
		return geetingWords.toUpperCase();
	}
}
