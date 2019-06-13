package com.pucminas.lyrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class AppLyricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppLyricsApplication.class, args);
	}

}
