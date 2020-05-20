package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceWebSocket9940Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWebSocket9940Application.class, args);
	}
	
	
}
