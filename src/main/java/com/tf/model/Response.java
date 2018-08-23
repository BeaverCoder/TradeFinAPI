package com.tf.model;

import java.util.Map;

public class Response {
	private Map<String, Object> message;

	public Response(Map<String, Object> message) {
		this.message = message;
	}

	public Map<String, Object> getMessage() {
		return message;
	}

	public void setMessage(Map<String, Object> message) {
		this.message = message;
	}

}
