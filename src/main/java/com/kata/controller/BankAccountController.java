package com.kata.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kata.service.AccountService;

/**
 * API permettant de deposer de l'agent, et consulter le solde du compte
 * @author ywick
 *
 */
@RestController
public class BankAccountController {
	private final AccountService accountService;
	
	BankAccountController(AccountService accountService){
		this.accountService = accountService;
	}

	/**
	 * Permet de deposer de l'argent
	 * curl -X POST localhost:8080/deposit -H 'Content-type:application/json' -d '{"customerId":1, "amount":2}'
	 * 
	 * @param transaction contenant l'id du client et le montant
	 * @return le nouveau solde
	 * @throws Exception si le montant est negatif
	 */
	@PostMapping("/deposit")
	public int deposit(@RequestBody Transaction transaction) throws Exception {
		if(transaction.getAmount() < 0) { 
			throw new Exception("La transaction n'a pas pu etre realisee car le montant n'est pas positif");
		}

		accountService.updateBalance(transaction.getCustomerId(), transaction.getAmount());
		return accountService.getBalance(transaction.getCustomerId());
	}
}
