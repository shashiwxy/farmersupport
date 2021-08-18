package com.farmersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmersupport.constant.FarmerSupportConstants;
import com.farmersupport.service.FarmerSupportService;

@RestController
@RequestMapping(value = FarmerSupportConstants.FARMER_SUPPORT_PATH)
public class FarmerSupportController {

	@Autowired
	private FarmerSupportService farmerSupportService;
	
	@GetMapping(value = FarmerSupportConstants.RAIN_API)
	public int getForecastInformation(@PathVariable final String pincode) {
		return farmerSupportService.getForecastInformation(pincode);
	}
	
}
