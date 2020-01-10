package application;

import com.fasterxml.jackson.core.JsonProcessingException;
import application.data.entity.TestRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("beans.xml")
public class LibraryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);
		TestRunner testRunner = context.getBean(TestRunner.class);
		try {
			testRunner.test();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
