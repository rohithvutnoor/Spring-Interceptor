package com.dev.works.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.dev.works.beans.Profile;

@Component
public class DevHandler {
	public Object handle(Object object) throws Exception {
		
		Profile profile = (Profile) object;
		
		if(StringUtils.isBlank(profile.getName())){
			throw new Exception("No Name");
		}
		System.out.println(profile);
		
		return profile;
	}
}
