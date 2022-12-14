package com.hhq.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

	private String type;
	private com.hhq.consumingrest.Value value;
	
	public Quote() {
		
	}
	
	
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public com.hhq.consumingrest.Value getValue() {
		return value;
	}



	public void setValue(com.hhq.consumingrest.Value value) {
		this.value = value;
	}



	@Override
	public String toString() {
		return "Quote{" + "type='" + type + '\'' + ", value=" + value + '}';
	}
 	
}
