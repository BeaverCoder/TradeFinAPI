package com.tf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tf.model.LetterOfCredit;
import com.tf.util.TfConstants;

@Repository
public class TradeFinanceDaoImpl implements TradeFinanceDao{
	
	private Connection conn;
	
	private Connection getConnection() throws SQLException {
		if(conn!=null) return conn;
		conn = DriverManager.getConnection(TfConstants.DB_URL, TfConstants.USER, TfConstants.PASS);
		return conn;
	}

	@Override
	public List<LetterOfCredit> getLCData(String cin) {
		
		List<LetterOfCredit> recievedLC = new ArrayList<LetterOfCredit>();
		
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from Tr where CIN="+cin);
			
			while(rs.next()) {
				LetterOfCredit lc = new LetterOfCredit();
				lc.setCin(rs.getLong("CIN"));
				lc.setLcType(rs.getString("LC Type"));
				lc.setLcNumber(rs.getString("LC Number"));
				lc.setSequence(rs.getString("Sequence"));
				lc.setRecordType(rs.getString("Record Type"));
				lc.setStatus(rs.getString("Status"));
				lc.setOutstandingAmount(rs.getLong("Outstanding Amount"));
				lc.setCurrency(rs.getString("Currency"));
				lc.setPaymentAmount(rs.getLong("Payment Amount"));
				lc.setPaymentCurrency(rs.getString("Payment Currency"));
				lc.setPaymentDate(rs.getString("Payment Date"));
				lc.setStartDate(rs.getString("Start Date"));
				lc.setExpiryDate(rs.getString("Expiry Date"));
				recievedLC.add(lc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recievedLC;
		
	}

	@Override
	public int getNumberOfLC(String cin) {
		int number = 0;
		try {
			Statement stmt = getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select count(distinct `LC Number`) from Tr where CIN="+cin);
			while(rs.next()) {
				number = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return number;
	}

}
