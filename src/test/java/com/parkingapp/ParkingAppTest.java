package com.parkingapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkingapp.controller.ParkingController;
import com.parkingapp.model.Parking;
import com.parkingapp.repository.ParkingRepo;
import com.parkingapp.service.ParkingServiceIMPL;

@WebMvcTest(ParkingController.class)
public class ParkingAppTest {
	private static final String END_POINT_PATH = "/parking/create";
	// prerequisites
	@Autowired
	MockMvc mockMvc;
	// prerequisites
	@Autowired
	ObjectMapper mapper;
	// Mocking repo
	@MockBean
	ParkingRepo parkingRepo;
	@MockBean
	private ParkingServiceIMPL service;
	
	@Test
	public void testAddShouldReturn201Created() throws Exception{
		Parking newUser = new Parking( 1, null, "2","1344", null, null, null, null);
		
		String requestBody = mapper.writeValueAsString(newUser);
		
		mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
				.content(requestBody))
				.andExpect(status().is2xxSuccessful());		
	}	
	
	@Test
	public void testAddShouldReturn400BadRequest() throws Exception{
		Parking newUser = new Parking(1, null, null, null, null, null, null, null);
		
		String requestBody = mapper.writeValueAsString(newUser);
		
		mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
				.content(requestBody))
				.andExpect(status().isBadRequest())
				.andDo(print());		
	}
}
