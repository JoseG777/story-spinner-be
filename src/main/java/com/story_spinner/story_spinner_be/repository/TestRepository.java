package com.story_spinner.story_spinner_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.story_spinner.story_spinner_be.model.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
