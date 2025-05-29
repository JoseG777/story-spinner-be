package com.story_spinner.story_spinner_be;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.story_spinner.story_spinner_be.model.TestEntity;
import com.story_spinner.story_spinner_be.repository.TestRepository;

@SpringBootApplication
public class StorySpinnerBeApplication {

    public static void main(String[] args) {
        // SpringApplication.run(StorySpinnerBeApplication.class, args);
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
        System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
        System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
		SpringApplication.run(StorySpinnerBeApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TestRepository repo) {
        return args -> {
            repo.save(new TestEntity("Connected to RDS - 4!"));
            System.out.println("Inserted test entity into PostgreSQL.");
        };
    }
}

//  ./mvnw spring-boot:run
//  ./mvnw clean install