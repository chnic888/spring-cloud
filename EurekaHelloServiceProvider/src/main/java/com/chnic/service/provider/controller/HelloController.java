package com.chnic.service.provider.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chnic.service.provider.exception.BadTitleException;
import com.google.common.collect.Sets;

@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private Registration registration;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private static final Set<String> TITLE_SET = Sets.newHashSet("mr", "mrs", "ms", "miss");
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/hello")
	@ResponseStatus(HttpStatus.OK)
	public String sayHello(@RequestParam(name = "title") String title, @RequestParam(name = "name") String name) {
		List<ServiceInstance> instanceList = discoveryClient.getInstances(registration.getServiceId());
		logger.info("Instance Size: " + instanceList.size());
		
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		logger.info("host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", service_id:" + registration.getServiceId());
		
		if (title != null && !TITLE_SET.contains(title.toLowerCase())) {
			throw new BadTitleException("Bad tittle");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Hello ").append(title).append(", ").append(name);
		return sb.toString();
	}
}
