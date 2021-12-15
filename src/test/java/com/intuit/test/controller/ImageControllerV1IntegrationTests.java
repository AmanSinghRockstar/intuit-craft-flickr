package com.intuit.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ImageControllerV1IntegrationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	void search_shouldWork() throws Exception {
		mockMvc.perform(get("/api/v1/image/search?query=forest"))
			.andExpect(status().isOk())
			.andExpect(content()
				      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
}
