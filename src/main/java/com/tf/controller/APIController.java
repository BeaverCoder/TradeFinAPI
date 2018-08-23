package com.tf.controller;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.tf.model.ApiGatewayResponse;
import com.tf.service.TradeFinanceService;
import com.tf.service.TradeFinanceServiceImpl;
import com.tf.util.APIResponseGenerator;


@Configuration
@ComponentScan(basePackages = {"com.tf"})
public class APIController implements RequestHandler<Map<String,Object>, ApiGatewayResponse> {
    
	@SuppressWarnings("unchecked")
	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(APIController.class);
		ctx.refresh();
		
		String cin = ((Map<String, Object>)input.get("queryStringParameters")).get("CIN").toString();
		TradeFinanceService tfService = ctx.getBean(TradeFinanceServiceImpl.class);
		
		Map<String, Object> results = tfService.getLCSummary(cin);
		
		ctx.close();
		return APIResponseGenerator.response(results);
		
	}
}