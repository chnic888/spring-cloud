package com.chnic.eureka.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AuthenticationFilter extends ZuulFilter {
	private static Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
	
	private final String TOKEN = "12345";
	
	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
		
        String token = request.getHeader("Authorization");
        if (!TOKEN.equalsIgnoreCase(token)) {
        	logger.error("Authencated failed with token: " + token);
        	context.setSendZuulResponse(false);
        	context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        	context.setResponseBody("Unauthorized Request");
        	return null;
        }
        
        return null;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
		Object proxy = context.get("proxy");
	    if (proxy != null && proxy.equals("hello-service")) {
	        return true;
	    }

		return false;
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
