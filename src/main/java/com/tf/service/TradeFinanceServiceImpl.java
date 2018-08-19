package com.tf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tf.dao.TradeFinanceDao;
import com.tf.model.LetterOfCredit;

@Service
public class TradeFinanceServiceImpl implements TradeFinanceService{

	@Autowired
	private TradeFinanceDao tradeDao;
	
	@SuppressWarnings("rawtypes")
	private Map summary;
	private List<LetterOfCredit> lcDetails;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getLCSummary(String cin) {
		
		lcDetails = tradeDao.getLCData(cin);
		
		summary = new HashMap<>();
		summary.put("CIN", cin);
		if(lcDetails.isEmpty()) {
			summary.put("Number of LC", 0);
			summary.put("status", "No LC for this CIN");
			return summary;
		}
		summary.put("Number of LC", tradeDao.getNumberOfLC(cin));
		summary.put("status", "Success");
		
		return summary;
	}

}
