package com.farmersupport.scheduler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.farmersupport.constant.FarmerSupportConstants;
import com.farmersupport.model.RainReport;

@EnableScheduling
public class ReportScheduler {

	@Autowired
	RainReport rainReport;
	
	private List<String> pincodes;//suppose we are having this details already

	@Scheduled(cron = FarmerSupportConstants.CRON_PATTERN)
	@Cacheable("rainReport")
	public void setRainReport() {
		Map<String, Integer> reports = new HashMap<>();
		//We can call our own API to get all the pincode we are providing this service
		pincodes.forEach(pincode -> {
			int value = 0;
			//value = value will be getting from RainForecast API
			reports.put(pincode, value);
		});
		rainReport.setRainReport(reports);
	}
	
}
