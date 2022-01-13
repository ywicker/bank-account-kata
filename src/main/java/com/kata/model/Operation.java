package com.kata.model;

import java.util.Date;

import com.kata.controller.Transaction;

public class Operation {
	public Operation(Transaction transaction) {
		this.date = new Date();
		this.amount = transaction.getAmount();
		this.type = transaction.getAmount() > 0 ? OperationType.DEPOSIT 
				: OperationType.WITHDRAWAL;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public OperationType getType() {
		return type;
	}
	public void setType(OperationType type) {
		this.type = type;
	}
	private Date date;
	private int amount;
	private OperationType type;
}
