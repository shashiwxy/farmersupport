package com.farmersupport.constant;

public class FarmerSupportConstants {

	public static final String FARMER_SUPPORT_PATH = "/farmersupport";
	
	public static final String RAIN_API = "/rainforecast/{pincode}";
	
	//Run every night at 12:00
	public static final String CRON_PATTERN = "0 0 * * *";
}
