package com.farmersupport.dummyrainservice;

import org.springframework.stereotype.Service;

@Service
public class DummyRainForecastService {

	public Integer dummyRainForecastingAPI(final String pincode) {
		int value = 1;
		/*
		 * It will call actual api of rainForecastService
		 *  value = rainForecastService.getRainForecastInformation(pincode)
		 */
		return value;
	}
}
