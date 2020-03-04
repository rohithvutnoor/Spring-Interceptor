package com.dev.works.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.works.beans.Profile;

@Component
public class MyOutboundInterfaceHandler {

	@Autowired
	RestTemplate restTemplate;

	public Profile callHandler(String url) {

		ResponseEntity<Profile> responseEntity = restTemplate.getForEntity(url, Profile.class);
		
		Profile response = responseEntity.getBody();

		return response;
	}
}
