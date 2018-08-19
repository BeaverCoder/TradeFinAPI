package com.tf.model;

import java.util.Map;

public class Response {
	private Map message;

	public Response(Map message) {
		this.message = message;
	}

	public Map getMessage() {
		return message;
	}

	public void setMessage(Map message) {
		this.message = message;
	}

}
