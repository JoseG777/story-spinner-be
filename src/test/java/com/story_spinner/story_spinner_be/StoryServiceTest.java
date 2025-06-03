package com.story_spinner.story_spinner_be;

import com.story_spinner.story_spinner_be.model.Story;
import com.story_spinner.story_spinner_be.repository.StoryRepository;
import com.story_spinner.story_spinner_be.service.StoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StoryServiceTest {

    private StoryRepository storyRepository;
    private StoryService storyService;

    @BeforeEach
    public void setup()
    {
        this.storyRepository = mock(StoryRepository.class);
        this.storyService = new StoryService(storyRepository);
    }

    @Test
    public void testCreateStory_success() {
        String content = "Once upon a time...";
        Story mockStory = new Story(content);

        when(storyRepository.save(any(Story.class))).thenReturn(mockStory);

        Story saved = storyService.createStory(content);

        assertNotNull(saved);
        assertEquals(content, saved.getStory());
        verify(storyRepository, times(1)).save(any(Story.class));
    }

    @Test
    public void testGetAllStories_success() {
        List<Story> mockStories = Arrays.asList(
            new Story("Story A"),
            new Story("Story B")
        );

        when(storyRepository.findAll()).thenReturn(mockStories);

        List<Story> result = storyService.getAllStories();

        assertEquals(2, result.size());
        assertEquals("Story A", result.get(0).getStory());
        assertEquals("Story B", result.get(1).getStory());
        verify(storyRepository, times(1)).findAll();
    }

    @Test
    public void testCreateStory_withNullStory() {
        assertThrows(NullPointerException.class, () -> {
            storyService.createStory(null);
        });
    }


}
