package com.online.ecommarce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class OnlineEcommerceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEcommerceSystemApplication.class, args);
		System.out.println("Application start.....");
		
	}

}
