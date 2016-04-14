package com.andigital.associate;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WebClient {

	private static Logger log = Logger.getLogger(WebClient.class);
	private static String CLIENT_ID = "YJ3ZHVSIVZ15W31LOP5WG3BFNSCYKW0XNSGD0PI5APB152YH";
	private static String CLIENT_SECRET = "SGUU2VYPMGGZNDV2H4MNSFBQSYUD1IMVOJA5NFGXRUXANPLK";
	private static String FOURSUARE_VERSION = "20160413"; // translates to the version of foursquare on that date
	
	public List<String> getVenues(String location)
	{
		Client client = Client.create();
		// would give all venues I guess "https://api.foursquare.com/v2/venues/search?near=%s&client_id=%s&client_secret=%s&v=%s"
		String urlToHit = String.format("https://api.foursquare.com/v2/venues/trending?near=%s&client_id=%s&client_secret=%s&v=%s", location, CLIENT_ID, CLIENT_SECRET, FOURSUARE_VERSION);
		log.info("Making a request to: " + urlToHit);
		// try catch to handle crashes when talking to API  (local firewall, foursquare down, wrong request format...)
		WebResource webResource = client.resource(urlToHit);
		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class); 
		
		
		String clientResponseBody = clientResponse.getEntity(String.class);
		log.info(clientResponseBody);
		
		int responseCode = clientResponse.getStatusInfo().getStatusCode();
			
		log.info("Client response code: " + responseCode);
		
		if(!(responseCode == 200))
		{
			// Handle problems
		}
		
		// should probably have a separate method for json parsing
		
		// How do I end up having a list of json objects and iterating through them to extract relevant values?
		JSONParser jsonParser = new JSONParser();
		try {
			jsonParser.parse(clientResponseBody);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// What exactly do I want to return?
		// Venue names for the start and more details later?
		return null;
	}
	

}
