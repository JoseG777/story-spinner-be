package com.story_spinner.story_spinner_be;

// import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.story_spinner.story_spinner_be.model.TestEntity;
import com.story_spinner.story_spinner_be.repository.TestRepository;

import com.story_spinner.story_spinner_be.model.Story;
import com.story_spinner.story_spinner_be.repository.StoryRepository;

@SpringBootApplication
public class StorySpinnerBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorySpinnerBeApplication.class, args);
    }

    /*
    @Bean
    public CommandLineRunner run(TestRepository repo, StoryRepository repo1) {
        return args -> {
            repo.save(new TestEntity("Connected to RDS - 004!"));
            repo1.save(new Story("What a great story! - 003"));
            System.out.println("Inserted test entities into PostgreSQL.");
        };
    }
    */
}

//  ./mvnw spring-boot:run
//  ./mvnw clean install