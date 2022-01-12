package com.kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.controller.BankAccountController;
import com.kata.controller.Transaction;
import com.kata.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BankAccountController.class)
public class BankAccountControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService accountService;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void depositTest() throws Exception {
		Transaction transaction = new Transaction(1, 2);
		String inputJson = mapToJson(transaction);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/deposit")
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}


	@Test
	public void withdrawalTest() throws Exception {
		Transaction transaction = new Transaction(1, -2);
		String inputJson = mapToJson(transaction);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/withdrawal")
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
}
