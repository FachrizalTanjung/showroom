package id.co.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CustomerApplication extends SpringBootServletInitializer {
	
	//Untuk menjalankan Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}