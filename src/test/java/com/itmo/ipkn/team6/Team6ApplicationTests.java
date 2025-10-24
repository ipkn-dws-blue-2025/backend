package com.itmo.ipkn.team6;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class Team6ApplicationTests {

	@Test
	void contextLoads() {
	}

}
