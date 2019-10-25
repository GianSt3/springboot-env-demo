package it.st3labs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Value("${demo.title}")
	String title;

	@Value("${demo.description}")
	String description;

	@Value("${demo.env-var}")
	String envVar;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-T:" + title + " -D:" + description + " -P:" + Arrays.toString(this.environment.getActiveProfiles()) + " -E:" + envVar);
	}
}
