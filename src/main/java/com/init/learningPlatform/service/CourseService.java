package com.init.learningPlatform.service;

import com.init.learningPlatform.model.Course;

import java.util.List;

public interface CourseService{
    List<Course> getAll();
    Course createCourse(Course course);
//    Course updateCourse(CourseUpdateWrapper courseUpdateWrapper, Long id);
    Course getCourseById(Long id);
    void deleteById(Long id);
}
