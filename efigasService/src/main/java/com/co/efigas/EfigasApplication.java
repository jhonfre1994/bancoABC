package com.co.efigas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EfigasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfigasApplication.class, args);
	}

}
