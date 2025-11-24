package com.itmo.ipkn.team6;

import org.openapitools.client.ApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Team6Application {

	public static void main(String[] args) {
		ApiClient apiClient = new ApiClient();
		SpringApplication.run(Team6Application.class, args);
	}

}
