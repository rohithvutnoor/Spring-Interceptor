package com.dev.works.configuration;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.util.ContentCachingResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {

	private String responseBody;

	public ResponseWrapper(HttpServletResponse response) throws IOException {
		super(response);

		ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper) response;

		String s = new String(responseWrapper.getContentAsByteArray());
		s = s.replace("{", "{\"name\":\"lenovo\",");

		this.setResponseBody(s);
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

}