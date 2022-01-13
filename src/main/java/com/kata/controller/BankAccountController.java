package com.kata.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(HttpStatus.OK)
	public int deposit(@RequestBody Transaction transaction) throws Exception {
		if(transaction.getAmount() < 0) { 
			throw new Exception("La transaction n'a pas pu etre realisee car le montant n'est pas positif");
		}

		accountService.updateBalance(transaction.getAccountId(), transaction.getAmount());
		return accountService.getBalance(transaction.getAccountId());
	}

	/**
	 * Permet de retirer de l'argent
	 * curl -X POST localhost:8080/withdrawal -H 'Content-type:application/json' -d '{"customerId":1, "amount":-2}'
	 * 
	 * @param transaction contenant l'id du client et le montant
	 * @return le nouveau solde
	 * @throws Exception si le montant est positif
	 */
	@PostMapping("/withdrawal")
	@ResponseStatus(HttpStatus.OK)
	public int withdrawal(@RequestBody Transaction transaction) throws Exception {
		if(transaction.getAmount() > 0) { 
			throw new Exception("La transaction n'a pas pu etre realisee car le montant est positif");
		}

		accountService.updateBalance(transaction.getAccountId(), transaction.getAmount());
		return accountService.getBalance(transaction.getAccountId());
	}
}
