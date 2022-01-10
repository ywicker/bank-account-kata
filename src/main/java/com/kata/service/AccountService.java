package com.kata.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	private HashMap<Integer, Integer> accounts;

	@PostConstruct
	public void initialize() {
		accounts = new HashMap<Integer, Integer>();
	}

	public int getBalance(final int idCustomer) {
		if(accounts.containsKey(idCustomer)) {
			return accounts.get(idCustomer);
		} else {
			return 0;
		}
	}

	public void updateBalance(final int idCustomer, final int amount){
		accounts.put(idCustomer, amount + getBalance(idCustomer));
	}
}
