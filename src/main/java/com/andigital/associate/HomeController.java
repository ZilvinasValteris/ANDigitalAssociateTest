package com.andigital.associate;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

	private static Logger log = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = GET)
    public String displayHome()
	{
		return "home";
	}
	
	@RequestMapping(value = "/getVenues", method = GET)
	public String displayVenues(HttpServletRequest request)
	{
		
		WebClient webClient = new WebClient();
		
		String location = request.getParameter("location");
		
		System.out.println("location attribute: " + location);
		log.info("Location used: " + location);
		
		webClient.getVenues(location);

		return "venues";
	}
	
}
