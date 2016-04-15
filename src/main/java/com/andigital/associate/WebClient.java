package com.andigital.associate;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WebClient {

	private static Logger log = Logger.getLogger(WebClient.class);
	private static String CLIENT_ID = "YJ3ZHVSIVZ15W31LOP5WG3BFNSCYKW0XNSGD0PI5APB152YH";
	private static String CLIENT_SECRET = "SGUU2VYPMGGZNDV2H4MNSFBQSYUD1IMVOJA5NFGXRUXANPLK";
	private static String FOURSUARE_VERSION = "20160413"; // translates to the version of foursquare on that date
	
	public List<String> getVenues(String location)
	{
		Client client = Client.create();
		String urlToHit = String.format("https://api.foursquare.com/v2/venues/trending?near=%s&client_id=%s&client_secret=%s&v=%s", location, CLIENT_ID, CLIENT_SECRET, FOURSUARE_VERSION);
		log.info("Making a request to: " + urlToHit);
		// try catch to handle crashes when talking to API  (local firewall, foursquare down, wrong request format...)
		WebResource webResource = client.resource(urlToHit);
		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class); 

		String clientResponseBody = clientResponse.getEntity(String.class);
		log.info("Client JSON response: " + clientResponseBody);
		
		int responseCode = clientResponse.getStatusInfo().getStatusCode();
			
		log.info("Client response code: " + responseCode);
		
		if(!(responseCode == 200))
		{
			// Handle problems
		}
		
		JSONObject jsonObject = new JSONObject(clientResponseBody);
		JSONObject responseBodyJson = jsonObject.getJSONObject("response");
		JSONArray venuesData = responseBodyJson.getJSONArray("venues");
		int numberOfVenues = venuesData.length();
		List<String> venueNames = new ArrayList<>();

		if(venuesData != null && numberOfVenues != 0)
		{
			for (int i = 0; i < numberOfVenues; i++)
			{
				venueNames.add(venuesData.getJSONObject(i).getString("name"));
			}
		}
		else
		{
			log.info("Empty client response - no venues found at location: " + location);
		}

		return venueNames;
	}
}
