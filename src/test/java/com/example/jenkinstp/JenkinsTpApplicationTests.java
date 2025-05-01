package com.example.jenkinstp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JenkinsTpApplicationTests {

	@Test
	void contextLoads() {
		System.out.print("Its a test class");
		assertEquals(true, true);
	}

}
