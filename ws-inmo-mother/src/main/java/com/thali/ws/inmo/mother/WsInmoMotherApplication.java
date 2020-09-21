package com.thali.ws.inmo.mother;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@PropertySource("classpath:endpoint.properties")
public class WsInmoMotherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsInmoMotherApplication.class, args);
	}

}
