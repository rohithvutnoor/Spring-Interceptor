package com.dev.works.configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.http.MediaType;
import org.springframework.web.util.ContentCachingResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {

	ByteArrayOutputStream byteArrayOutputStream;
	PrintWriter printWriter;
	
	ByteArrayPrinter pw = new ByteArrayPrinter();
	private String responseBody;
	
	public ResponseWrapper(HttpServletResponse response) throws IOException {
		super(response);

		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
		
		byteArrayOutputStream = new ByteArrayOutputStream();
		
		String s = new String(responseWrapper.getContentAsByteArray());
		
		byteArrayOutputStream.write(s.getBytes());
		this.setResponseBody(byteArrayOutputStream.toString());
		
	}

/*	@Override
    public void setContentType(final String type) {
        super.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    @Override
    public PrintWriter getWriter() {
        return pw.getWriter();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        ServletResponse response = this.getResponse();

        String ct = (response != null) ? response.getContentType() : null;
        return pw.getStream();
    }*/

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
    
}
