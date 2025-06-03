package com.story_spinner.story_spinner_be.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue
    @Column(name = "room_id", nullable = false, updatable = false, unique = true)
    private UUID roomId;

    @Column(name = "story", nullable = false, columnDefinition = "TEXT")
    private String story;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Story(){}

    public Story(String story_)
    {
        this.story = story_;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getRoomId()
    {
        return this.roomId;
    }

    @PrePersist // this means it will run before being added to the database
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getCreationTime()
    {
        return this.createdAt;
    }

    public void setStory(String story_)
    {
        this.story = story_;
    }

    public String getStory()
    {
        return this.story;
    }
}
