package com.example.cab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CabBookingApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(CabBookingApplication.class, args);

		Starter starter =context.getBean(Starter.class);
		starter.begin();
	}

}
