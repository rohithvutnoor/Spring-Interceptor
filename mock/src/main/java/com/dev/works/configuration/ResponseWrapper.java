package com.dev.works.configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.http.MediaType;

public class ResponseWrapper extends HttpServletResponseWrapper {

	ByteArrayOutputStream byteArrayOutputStream;
	PrintWriter printWriter;
	
	ByteArrayPrinter pw = new ByteArrayPrinter();
	
	public ResponseWrapper(HttpServletResponse response) throws IOException {
		super(response);

		ServletOutputStream outputStream = response.getOutputStream();
		
		byteArrayOutputStream = new ByteArrayOutputStream();
		
		byteArrayOutputStream.write("{\"name\":\"rohith\"}".getBytes());
		
		String responseData = byteArrayOutputStream.toString();
		
	}

	@Override
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
    }
    
}
