package com.chnic.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping(value = "/config")
	public String getConfig() {
		return url + " : " + port;
	}
}