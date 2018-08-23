package com.tf.model;

public class LetterOfCredit {

	private long cin;
	private String lcType;
	private String lcNumber;
	private String sequence;
	private String recordType;
	private String status;
	private long outstandingAmount;
	private String currency;
	private long paymentAmount;
	private String paymentCurrency;
	private String paymentDate;
	private String startDate;
	private String expiryDate;

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public String getLcType() {
		return lcType;
	}

	public void setLcType(String lcType) {
		this.lcType = lcType;
	}

	public String getLcNumber() {
		return lcNumber;
	}

	public void setLcNumber(String lcNumber) {
		this.lcNumber = lcNumber;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(long outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "LetterOfCredit [cin=" + cin + ", lcType=" + lcType + ", lcNumber=" + lcNumber + ", sequence=" + sequence
				+ ", recordType=" + recordType + ", status=" + status + ", outstandingAmount=" + outstandingAmount
				+ ", currency=" + currency + ", paymentAmount=" + paymentAmount + ", paymentCurrency=" + paymentCurrency
				+ ", paymentDate=" + paymentDate + ", startDate=" + startDate + ", expiryDate=" + expiryDate + "]";
	}

}
