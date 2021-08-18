package com.farmersupport.provider;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmersupport.dummyrainservice.DummyRainForecastService;
import com.farmersupport.model.RainReport;

@Service
public class FarmerSupportProvider {

	@Autowired
	RainReport rainReport;
	
	/*
	 * Assuming RainForecastingService exposed it's API to get rain forecasting
	 * private RainForecastService rainForecastService
	 */
	@Autowired
	DummyRainForecastService rainForecastService;


	public int getForecastInformation(final String pincode) {
		int rainForecastValue = 0;

		Future<Integer> future = Executors.newSingleThreadExecutor().submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// trying to get value from cache first
				Integer value = rainReport.getRainReport().get(pincode);
				if (value == null)
					value = rainForecastService.dummyRainForecastingAPI(pincode);
				return value;
			}

		});

		try {
			/*
			 * future.get(4, TimeUnit.SECONDS) will give result from rainForecaseService
			 * Assuming 1 second taking by our API's to calculate and send data to farmer So
			 * giving 4 sec to RainForecastService to respond
			 */
			rainForecastValue = future.get(4, TimeUnit.SECONDS);
		} catch (TimeoutException | InterruptedException | ExecutionException e) {
			future.cancel(true);
			// If timeout is happening that means if API not able to give response within 4
			// seconds
			rainForecastValue = -1;
		}
		return rainForecastValue;
	}

}
