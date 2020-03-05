package com.dev.works.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Inside RequestFilter doFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		RequestWrapper requestWrapper = new RequestWrapper(req);
		ResponseWrapper responseWrapper = new ResponseWrapper(res);
		chain.doFilter(requestWrapper, responseWrapper);
		response.getOutputStream().write("{\\\"name\\\":\\\"rohith123\\\"}".getBytes());
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
	
	
}
