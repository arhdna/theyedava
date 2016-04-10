package com.sai.one.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericError implements Entity{
	
	@JsonProperty("error_message")
	private List<? extends Object> message;

	public List<? extends Object> getMessage() {
		return message;
	}

	public void setMessage(List<? extends Object> message) {
		this.message = message;
	}


}
