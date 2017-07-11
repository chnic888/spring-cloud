package com.chnic.eureka.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.netflix.hystrix.exception.HystrixBadRequestException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad format")
public class BadFormatException extends HystrixBadRequestException {

	private static final long serialVersionUID = 1L;
	
	public BadFormatException(String message) {
		super(message);
	}
}
