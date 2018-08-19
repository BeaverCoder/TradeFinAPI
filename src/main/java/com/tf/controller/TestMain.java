package com.tf.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tf.dao.TradeFinanceDao;
import com.tf.dao.TradeFinanceDaoImpl;
import com.tf.util.TfConstants;

@Configuration
@ComponentScan(basePackages = {"com.tf"})
public class TestMain {
	public static void main(String[] args) throws SQLException {
		/*Connection conn = DriverManager.getConnection(TfConstants.DB_URL, TfConstants.USER, TfConstants.PASS);
		System.out.println("Success");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Tr");
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}*/
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(TestMain.class);
		ctx.refresh();
		
		
		TradeFinanceDao dao = ctx.getBean(TradeFinanceDaoImpl.class);
		System.out.println(dao.getNumberOfLC("1234"));
		ctx.close();

/*		List<TestModel> lis = new ArrayList<>();
		lis.add(new TestModel(1, "a"));
		lis.add(new TestModel(1, "b"));
		lis.add(new TestModel(2, "a"));
		System.out.println(lis.stream().map(tm -> tm.getJ()).collect(Collectors.toSet()));*/
		
	}
	
	public String getLCAmt(String CIN) throws SQLException {
		Connection conn = DriverManager.getConnection(TfConstants.DB_URL, TfConstants.USER, TfConstants.PASS);
		System.out.println("Success");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Tr where CIN="+CIN);
		String result = "Hi"; 
		while(rs.next()) {
			result = rs.getString(12);
		}
		return result;
	}
}
