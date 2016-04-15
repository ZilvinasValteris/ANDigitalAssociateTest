package com.andigital.associate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WebClientTest {

	@Test
	public void listOfLocationsReturned()
	{
		WebClient webClient = new WebClient();
		
		List<String> venuesReturned = webClient.getVenues("London");
		
		assertTrue(!(venuesReturned.isEmpty()));
	}
	
}
