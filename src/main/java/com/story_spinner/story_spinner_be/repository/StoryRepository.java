package com.story_spinner.story_spinner_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.story_spinner.story_spinner_be.model.Story;

import java.util.UUID;

public interface StoryRepository extends JpaRepository<Story, UUID>{

    
} 
