package com.init.learningPlatform.service;

import com.init.learningPlatform.model.Course;
import com.init.learningPlatform.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }


    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
