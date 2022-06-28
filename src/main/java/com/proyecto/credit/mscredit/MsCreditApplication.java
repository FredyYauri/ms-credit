package com.proyecto.credit.mscredit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCreditApplication.class, args);
	}

}
