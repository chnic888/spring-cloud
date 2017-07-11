package com.chnic.eureka.consumer.configuration;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.chnic.eureka.consumer.exception.BadFormatException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

@Component
public class ErrorResponseDecoder implements ErrorDecoder {

	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Exception decode(String methodKey, Response response) {
		try {
			String body = Util.toString(response.body().asReader());
			Map<String, String> bodyMap = mapper.readValue(body, new TypeReference<Map<String, String>>() {});
			
			if (response.status() == HttpStatus.BAD_REQUEST.value()
					&& bodyMap.get("exception").equals("com.chnic.service.provider.exception.BadTitleException")) {
				return new BadFormatException("BadTitleException");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return FeignException.errorStatus(methodKey, response);
	}

}
