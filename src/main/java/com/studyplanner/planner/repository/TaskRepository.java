package com.studyplanner.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyplanner.planner.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}