package com.chnic.service.provider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad title")
public class BadTitleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadTitleException(String message) {
		super(message);
	}

}
