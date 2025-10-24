package com.itmo.ipkn.team6;

import org.springframework.boot.SpringApplication;

public class TestTeam6Application {

	public static void main(String[] args) {
		SpringApplication.from(Team6Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
