package com.farmersupport.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.farmersupport.provider.FarmerSupportProvider;

@SpringBootTest(classes = {FarmerSupportService.class})
public class FarmerSupportServiceTest {

	@Autowired
	FarmerSupportService service;
	
	@MockBean
	FarmerSupportProvider provider;
	
	@Test
	public void testGetForecastInformationForRain() {
		Mockito.when(provider.getForecastInformation(Mockito.anyString())).thenReturn(1);
		int forecastInformation = service.getForecastInformation("445566");
		Assertions.assertEquals(forecastInformation, 1);
	}
	
	@Test
	public void testGetForecastInformationForNoRain() {
		Mockito.when(provider.getForecastInformation(Mockito.anyString())).thenReturn(0);
		int forecastInformation = service.getForecastInformation("667788");
		Assertions.assertEquals(forecastInformation, 0);
	}
	
	@Test
	public void testGetForecastInformationForRetry() {
		Mockito.when(provider.getForecastInformation(Mockito.anyString())).thenReturn(-1);
		int forecastInformation = service.getForecastInformation("889900");
		Assertions.assertEquals(forecastInformation, -1);
	}
}
