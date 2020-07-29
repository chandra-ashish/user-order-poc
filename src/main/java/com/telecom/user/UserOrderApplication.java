package com.telecom.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.telecom.user")
@SpringBootApplication
public class UserOrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserOrderApplication.class, args);
	}
}
