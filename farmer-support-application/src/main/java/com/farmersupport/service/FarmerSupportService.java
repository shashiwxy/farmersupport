package com.farmersupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmersupport.provider.FarmerSupportProvider;

@Service
public class FarmerSupportService {

	@Autowired
	private FarmerSupportProvider farmerSupportProvider;
	
	public int getForecastInformation(final String pincode) {
		return farmerSupportProvider.getForecastInformation(pincode);
	}
}
