package com.dev.works.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.works.beans.MyBean;
import com.dev.works.beans.Profile;
import com.dev.works.service.DevService;

@RestController
public class DevController {

	@Autowired
	DevService devService;
	
	@GetMapping(value = "/get")
	public MyBean getRequest() {
		MyBean response = devService.helloService();
		return response;
	}

	@PostMapping(value = "/profile")
	public MyBean getRequest(@RequestBody Profile profile) {
		
		System.out.println(profile.toString());
		
		
		MyBean response = devService.helloService();
		
		
		return response;
	}
	
}
