package com.kata.service;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.kata.model.Account;
import com.kata.model.Operation;

/**
 * Service permettant d'acceder aux comptes des clients
 * @author ywick
 *
 */
@Service
public class AccountService {

	private HashMap<Integer, Account> accounts;

	@PostConstruct
	public void initialize() {
		accounts = new HashMap<Integer, Account>();
	}

	/**
	 * Permet de recuperer le compte
	 * Si le compte n'existe pas retourne un compte vide
	 * 
	 * @param idAccount
	 * @return le compte
	 */
	public Account getAccount(final int idAccount) {
		if(accounts.containsKey(idAccount)) {
			return accounts.get(idAccount);
		} else {
			return new Account();
		}
	}

	public int getBalance(final int idAccount) {
		return getAccount(idAccount).getBalance();
	}

	/**
	 * Modification du solde d'un client
	 * Le client est cree si il n'existe pas (pas de service de creation de compte)
	 * 
	 * @param idCustomer
	 * @param amount
	 */
	public void updateBalance(final int idAccount, final int amount){
		Account account = getAccount(idAccount);
		account.setBalance(amount + account.getBalance());
		accounts.put(idAccount, account);
	}

	public void addOperation(final int idAccount, final Operation operation) {
	}
}
