package com.tf.util;

import java.util.HashMap;
import java.util.Map;

import com.tf.model.ApiGatewayResponse;
import com.tf.model.Response;

public class APIResponseGenerator {
	
	public static ApiGatewayResponse response(Map result) {
		
		Response responseBody = new Response(result);
		
		Map<String, String> headers = new HashMap<>();
		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(headers)
				.build();
		
	}
	
}
