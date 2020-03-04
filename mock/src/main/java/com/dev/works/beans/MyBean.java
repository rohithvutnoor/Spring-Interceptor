package com.dev.works.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

	private String desc;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ID: " + this.id + " Desc: " + this.getDesc();
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
