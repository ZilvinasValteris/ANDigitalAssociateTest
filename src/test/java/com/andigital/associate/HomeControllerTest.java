package com.andigital.associate;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class HomeControllerTest {

    private HomeController homeController;
    private HttpServletRequest servletRequest;

    @Before
    public void setup()
    {
        homeController = new HomeController();
        servletRequest = mock(HttpServletRequest.class);
    }

    @Test
    public void homePageReturned()
    {
        String pageReturned = homeController.displayHome();

        assertEquals("home", pageReturned);
    }

    @Test
    public void venuesPageReturned()
    {
        String pageReturned = homeController.displayVenues(servletRequest);

        assertEquals("venues", pageReturned);
    }

}
