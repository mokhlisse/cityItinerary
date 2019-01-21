package com.badre.cityitinerary.cityservice;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.badre.cityitinerary.cityservice.model.Route;
import com.badre.cityitinerary.cityservice.services.RouteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CityServiceApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class RouteServiceTest {

	@Autowired
	RouteService routeService;

	@Test
	@Ignore
	public void getRouteTest() throws InterruptedException {

		Integer routeId = 1;
		Route route = routeService.getRoute(routeId);
		Assert.assertNotNull(route);
	}
}
