package com.farmersupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FarmerSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerSupportApplication.class, args);
	}

}
