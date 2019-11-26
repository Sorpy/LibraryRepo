package data.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		TestRunner testRunner = new TestRunner();
		try {
			testRunner.test();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
