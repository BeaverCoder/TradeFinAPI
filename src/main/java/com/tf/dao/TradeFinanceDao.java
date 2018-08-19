package com.tf.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tf.model.LetterOfCredit;

@Repository
public interface TradeFinanceDao {
	public List<LetterOfCredit> getLCData(String cin);
	public int getNumberOfLC(String cin);
}
