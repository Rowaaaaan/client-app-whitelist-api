package com.iaccess.progtest.ClientAppWhitelistAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ClientAppWhitelistApiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext();

		SpringApplication.run(ClientAppWhitelistApiApplication.class, args);
	}

}
