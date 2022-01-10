package com.kata.controller;

public class Transaction {
	public Transaction(int customerId, int amount) {
		super();
		this.customerId = customerId;
		this.amount = amount;
	}
	private int customerId;
	private int amount;

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
