package com.virtusa.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class SpavApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpavApplication.class, args);
	}

}
