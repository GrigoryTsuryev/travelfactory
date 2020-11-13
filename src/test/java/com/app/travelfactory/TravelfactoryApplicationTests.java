package com.app.travelfactory;

import com.app.travelfactory.entities.Campaign;
import com.app.travelfactory.entities.Registration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TravelfactoryApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldCreateCampaign() throws Exception {
		Campaign campaign = new Campaign();
		campaign.setName("name");
		String body = objectMapper.writeValueAsString(campaign);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/campaign/marketing/ws/partner/campaign/create")
				.content(body)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isCreated())
				.andExpect(handler().methodName("createCampaign"));

	}

	@Test
	public void shouldCreateRegistration() throws Exception {
		Registration registration = new Registration();
		Campaign campaign = new Campaign();
		campaign.setName("name");
		campaign.setId(1L);
		registration.setCampaign(campaign);
		registration.setEmail("test@test.com");
		registration.setPhone("922559291111");
		String body = objectMapper.writeValueAsString(registration);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/registration/marketing/ws/partner/campaign/create")
				.content(body)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(handler().methodName("createRegistration"));

	}


	@Test
	public void whenCreateRegistrationWithNoContact_thanNoContactException() throws Exception {
		Registration registration = new Registration();
		Campaign campaign = new Campaign();
		campaign.setName("name");
		campaign.setId(1L);
		registration.setCampaign(campaign);
		registration.setEmail("tet@test.com");
		registration.setPhone("922559291111");
		String body = objectMapper.writeValueAsString(registration);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/registration/marketing/ws/partner/campaign/create")
				.content(body)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().is4xxClientError())
				.andExpect(handler().methodName("createRegistration"));
	}

}
