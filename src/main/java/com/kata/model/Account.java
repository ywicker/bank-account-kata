package com.kata.model;

import java.util.Collections;
import java.util.List;

public class Account {
	private int balance;
	private List<Operation> operation;

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	public int getBalance() {
		return balance;
	}

	public Account() {
		this.balance = 0;
		this.operation = Collections.emptyList();
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
