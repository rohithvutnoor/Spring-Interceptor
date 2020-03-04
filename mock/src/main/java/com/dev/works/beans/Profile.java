package com.dev.works.beans;

import org.springframework.stereotype.Component;

@Component
public class Profile {

	private String name;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Name: "+this.name+", Id: "+this.id;
	}
}
