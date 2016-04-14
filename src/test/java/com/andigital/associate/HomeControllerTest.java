package com.andigital.associate;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class HomeControllerTest {

    private HomeController homeController;

    @Before
    public void setup()
    {
        homeController = new HomeController();
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
        HttpServletRequest servletRequest = mock(HttpServletRequest.class);

        String pageReturned = homeController.displayVenues(servletRequest);

        assertEquals("venues", pageReturned);
    }

}
