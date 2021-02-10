package com.init.learningPlatform.repository;

import com.init.learningPlatform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

