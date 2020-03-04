package com.dev.works.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.works.beans.MyBean;
import com.dev.works.beans.Profile;
import com.dev.works.integration.MyOutboundInterfaceHandler;

@Service
public class DevService {

	String url = "https://my-json-server.typicode.com/typicode/demo/profile";
	
	@Autowired
	MyOutboundInterfaceHandler handler;
	
	public MyBean helloService() {
		
		Profile object = handler.callHandler(url);
		
		MyBean bean = new MyBean();
		
		bean.setId(UUID.randomUUID().toString());
		bean.setDesc(object.getName());
		
		return bean;
	}

}
