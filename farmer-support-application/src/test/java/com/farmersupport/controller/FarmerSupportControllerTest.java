package com.farmersupport.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.farmersupport.service.FarmerSupportService;

@SpringBootTest(classes = {FarmerSupportController.class})
public class FarmerSupportControllerTest {
	
	@Autowired
	private FarmerSupportController controller;
	
	@MockBean
	private FarmerSupportService service;
	
	@Test
	public void testGetForecastInformationForRain() {
		Mockito.when(service.getForecastInformation(Mockito.anyString())).thenReturn(1);
		int forecastInformation = controller.getForecastInformation("123456");
		Assertions.assertEquals(forecastInformation, 1);
	}
	
	@Test
	public void testGetForecastInformationForNoRain() {
		Mockito.when(service.getForecastInformation(Mockito.anyString())).thenReturn(0);
		int forecastInformation = controller.getForecastInformation("123456");
		Assertions.assertEquals(forecastInformation, 0);
	}
	
	@Test
	public void testGetForecastInformationForRetry() {
		Mockito.when(service.getForecastInformation(Mockito.anyString())).thenReturn(-1);
		int forecastInformation = controller.getForecastInformation("123456");
		Assertions.assertEquals(forecastInformation, -1);
	}

}

