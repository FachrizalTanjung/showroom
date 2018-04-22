package com.showroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ShowroomApplication extends SpringBootServletInitializer {
	
	//Untuk menjalankan Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(ShowroomApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(){
		
		return new RestTemplate();
	}
}