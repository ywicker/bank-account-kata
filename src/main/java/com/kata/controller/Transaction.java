package com.kata.controller;

public class Transaction {
	public Transaction(int accountId, int amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}
	private int accountId;
	private int amount;

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
