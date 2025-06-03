package com.story_spinner.story_spinner_be.service;

import com.story_spinner.story_spinner_be.model.Story;
import com.story_spinner.story_spinner_be.repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {
    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository_)
    {
        this.storyRepository = storyRepository_;
    }

    public Story createStory(String story_)
    {
        Story story = new Story(story_);
        return storyRepository.save(story);
    }

    public List<Story> getAllStories()
    {
        return storyRepository.findAll();
    }
}
