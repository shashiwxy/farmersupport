package com.farmersupport.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class RainReport {

	private Map<String, Integer> reports = new HashMap<>();

	public Map<String, Integer> getRainReport() {
		return reports;
	}

	@Cacheable("rainReport")
	public void setRainReport(Map<String, Integer> rainReport) {
		this.reports = rainReport;
	}
	
	
	
}
