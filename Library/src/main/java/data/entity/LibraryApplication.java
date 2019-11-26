package data.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
		TestRunner testRunner = new TestRunner();
		try {
			testRunner.test();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
