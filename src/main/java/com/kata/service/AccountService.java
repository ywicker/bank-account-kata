package com.kata.service;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * Service permettant d'acceder aux comptes des clients
 * @author ywick
 *
 */
@Service
public class AccountService {

	private HashMap<Integer, Integer> accounts;

	@PostConstruct
	public void initialize() {
		accounts = new HashMap<Integer, Integer>();
	}

	/**
	 * Permet de recuperer le solde d'un client
	 * A 0 si le client n'existe pas (pas de service de creation de compte)
	 * 
	 * @param idCustomer
	 * @return le solde
	 */
	public int getBalance(final int idCustomer) {
		if(accounts.containsKey(idCustomer)) {
			return accounts.get(idCustomer);
		} else {
			return 0;
		}
	}

	/**
	 * Modification du solde d'un client
	 * Le client est cree si il n'existe pas (pas de service de creation de compte)
	 * 
	 * @param idCustomer
	 * @param amount
	 */
	public void updateBalance(final int idCustomer, final int amount){
		accounts.put(idCustomer, amount + getBalance(idCustomer));
	}
}
