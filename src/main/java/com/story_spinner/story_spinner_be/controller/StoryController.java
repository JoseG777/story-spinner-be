package com.story_spinner.story_spinner_be.controller;

// import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.story_spinner.story_spinner_be.model.Story;
// import com.story_spinner.story_spinner_be.repository.StoryRepository;
import com.story_spinner.story_spinner_be.service.StoryService;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService_)
    {
        this.storyService = storyService_;
    }

    @PostMapping
    public ResponseEntity<Story> postStory(@RequestBody String content_)
    {
        Story story = storyService.createStory(content_);
        return ResponseEntity.ok(story);
    }

}
