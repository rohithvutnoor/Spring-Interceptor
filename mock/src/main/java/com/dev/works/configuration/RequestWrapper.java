package com.dev.works.configuration;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.dev.works.beans.Profile;
import com.google.gson.Gson;

public class RequestWrapper extends HttpServletRequestWrapper {

	ByteArrayOutputStream byteArrayOutputStream;

	String body;

	public RequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		System.out.println("Inside RequestWrapper Constructor");
		StringBuilder textBuilder = new StringBuilder();

		try (Reader reader = new BufferedReader(
				new InputStreamReader(request.getInputStream(), Charset.forName(StandardCharsets.UTF_8.name())))) {
			int c = 0;
			while ((c = reader.read()) != -1) {
				textBuilder.append((char) c);
			}
		}

		Profile profile = new Profile();
		profile.setId("123");
		profile.setName("Rohith");

		Gson json = new Gson();

		String profileText = json.toJson(profile);

		this.body = profileText;

		byteArrayOutputStream = new ByteArrayOutputStream();
		byteArrayOutputStream.write(profileText.getBytes());
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return new ServletInputStream() {

			InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

			@Override
			public int read() throws IOException {
				return inputStream.read();
			}

			@Override
			public void setReadListener(ReadListener listener) {
			}

			@Override
			public boolean isReady() {
				return true;
			}

			@Override
			public boolean isFinished() {
				return false;
			}
		};
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}

	public String getBody() {
		return this.body;
	}

}
