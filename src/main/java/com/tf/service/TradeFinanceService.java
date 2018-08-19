package com.tf.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface TradeFinanceService {
	public Map<String, Object> getLCSummary(String cin);
}
