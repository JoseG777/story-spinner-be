package com.story_spinner.story_spinner_be;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StorySpinnerBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorySpinnerBeApplication.class, args);
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		SpringApplication.run(StorySpinnerBeApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TestRepository repo) {
        return args -> {
            repo.save(new TestEntity("✅ Connected to RDS!"));
            System.out.println("Inserted test entity into PostgreSQL.");
        };
    }
}