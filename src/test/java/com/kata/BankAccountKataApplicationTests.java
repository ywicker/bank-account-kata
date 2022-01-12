package com.kata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.controller.BankAccountController;

@SpringBootTest
class BankAccountKataApplicationTests {
	@Autowired
	BankAccountController bankAccountController;

	@Test
	void contextLoads() {
		assertThat(bankAccountController).isNotNull();
	}
}
