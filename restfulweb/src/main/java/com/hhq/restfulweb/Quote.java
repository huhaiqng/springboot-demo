package com.hhq.restfulweb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

	private String type;
	private com.hhq.restfulweb.Value value;
	
	public Quote() {
		
	}
	
	
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public com.hhq.restfulweb.Value getValue() {
		return value;
	}



	public void setValue(com.hhq.restfulweb.Value value) {
		this.value = value;
	}



	@Override
	public String toString() {
		return "Quote{" + "type='" + type + '\'' + ", value=" + value + '}';
	}
 	
}
