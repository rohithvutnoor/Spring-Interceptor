package com.dev.works.configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.util.ContentCachingResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {

	//ByteArrayOutputStream byteArrayOutputStream;
	//PrintWriter printWriter;
	
	//ByteArrayPrinter pw = new ByteArrayPrinter();
	private String responseBody;
	
	public ResponseWrapper(HttpServletResponse response) throws IOException {
		super(response);

		ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper)response;
		
		//byteArrayOutputStream = new ByteArrayOutputStream();
		
		String s = new String(responseWrapper.getContentAsByteArray());
		s = s.replace("{", "{\"name\":\"lenovo\",");
		//byteArrayOutputStream.write(s.getBytes());
		this.setResponseBody(s);
		
	}
	
	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
    
}
