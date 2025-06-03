package com.story_spinner.story_spinner_be;

import com.story_spinner.story_spinner_be.model.Story;
import com.story_spinner.story_spinner_be.service.StoryService;
import com.story_spinner.story_spinner_be.controller.StoryController;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(StoryController.class)
public class StoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoryService storyService;

    @Test
    public void testPostStory_success() throws Exception {
        String content = "Once upon a time...";
        Story mockStory = new Story(content);

        // Optional: manually set a UUID so it doesn't serialize null
        mockStory.setStory(content);

        Mockito.when(storyService.createStory(any(String.class))).thenReturn(mockStory);

        mockMvc.perform(post("/api/stories")
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"" + content + "\""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.story").value(content));
    }
}

