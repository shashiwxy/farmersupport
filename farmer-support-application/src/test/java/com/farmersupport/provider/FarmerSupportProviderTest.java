package com.farmersupport.provider;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.farmersupport.dummyrainservice.DummyRainForecastService;
import com.farmersupport.model.RainReport;

@SpringBootTest(classes = {FarmerSupportProvider.class})
public class FarmerSupportProviderTest {

	@Autowired
	FarmerSupportProvider provider;
	
	@MockBean
	RainReport rainReport;
	
	@MockBean
	DummyRainForecastService rainForcastService;
	
	private static Map<String, Integer> reporst;
	
	@BeforeAll
	public static void init() {
		reporst = new HashMap<>();
		reporst.put("112233", 1);
		reporst.put("223344", 0);
	}
	
	@Test
	public void testGetForecastInformationIfCacheHasValueForRain() {
		Mockito.when(rainReport.getRainReport()).thenReturn(reporst);
		int forecastInformation = provider.getForecastInformation("112233");
		Assertions.assertEquals(forecastInformation, 1);
	}
	
	@Test
	public void testGetForecastInformationIfCacheHasValueForNoRain() {
		Mockito.when(rainReport.getRainReport()).thenReturn(reporst);
		int forecastInformation = provider.getForecastInformation("223344");
		Assertions.assertEquals(forecastInformation, 0);
	}
	
	@Test
	public void testGetForecastInformationIfCacheHasNoValueForRain() {
		Mockito.when(rainReport.getRainReport()).thenReturn(reporst);
		Mockito.when(rainForcastService.dummyRainForecastingAPI(Mockito.anyString())).thenReturn(1);
		int forecastInformation = provider.getForecastInformation("445566");
		Assertions.assertEquals(forecastInformation, 1);
	}
	
	@Test
	public void testGetForecastInformationIfCacheHasNoValueForNoRain() {
		Mockito.when(rainReport.getRainReport()).thenReturn(reporst);
		Mockito.when(rainForcastService.dummyRainForecastingAPI(Mockito.anyString())).thenReturn(0);
		int forecastInformation = provider.getForecastInformation("445566");
		Assertions.assertEquals(forecastInformation, 0);
	}
	
	@Test
	public void testGetForecastInformationIfCacheHasNoValueForRetry() {
		Mockito.when(rainReport.getRainReport()).thenReturn(reporst);
		Mockito.when(rainForcastService.dummyRainForecastingAPI(Mockito.anyString())).thenReturn(-1);
		int forecastInformation = provider.getForecastInformation("445566");
		Assertions.assertEquals(forecastInformation, -1);
	}
}
