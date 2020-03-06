package com.dev.works.configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
@Order(2)
public class ResponseFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Inside ResponseFilter doFilter");
		HttpServletResponse res = (HttpServletResponse) response;

		ResponseWrapper responseWrapper = new ResponseWrapper(res);
		chain.doFilter(request, responseWrapper);
		res.getOutputStream().write(responseWrapper.getResponseBody().getBytes());
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
