package com.tf.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tf.dao.TradeFinanceDao;
import com.tf.model.LetterOfCredit;

@Service
public class TradeFinanceServiceImpl implements TradeFinanceService{

	private static final Logger logger = LogManager.getLogger(TradeFinanceService.class);
	
	@Autowired
	private TradeFinanceDao tradeDao;
	
	private Map<String, Object> summary;
	private List<LetterOfCredit> lcDetails;
	private List<String> expiryLC;
	
	private List<String> getExpiringLC(List<LetterOfCredit> lcs){
		Set<String> uniqueSet = new HashSet<>(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		expiryLC = new ArrayList<>();
		lcs.forEach(lc -> {
			logger.info(expiryLC);
			
			if(!uniqueSet.contains(lc.getLcNumber())) {
				uniqueSet.add(lc.getLcNumber());
				LocalDate ldate = LocalDate.parse(lc.getExpiryDate(), formatter);
				if(ChronoUnit.MONTHS.between(today, ldate)<=0) {
					expiryLC.add(lc.getExpiryDate());
				}
			}
		});
		logger.info(expiryLC);
		logger.info(uniqueSet);
		return expiryLC;
	}
	
	@Override
	public Map<String, Object> getLCSummary(String cin) {
		
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
		summary.put("Total Exposure", tradeDao.getTotalExposure(cin));
		summary.put("Work in Progress", tradeDao.getWorkInProgress(cin));
		expiryLC = getExpiringLC(lcDetails);
		summary.put("Expiring LC", expiryLC.size());
		
		if(expiryLC.size()==0) {
			summary.put("Expiring Amount", 0);
			return summary;
		}
		
		summary.put("Expiring Amount", tradeDao.getDueExpiringAmount(cin, expiryLC));
		
		return summary;
	}
	
}
