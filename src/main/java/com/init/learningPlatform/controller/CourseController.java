package com.init.learningPlatform.controller;

import com.init.learningPlatform.helper.Response;
import com.init.learningPlatform.model.Course;
import com.init.learningPlatform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
//@Secured("")
@RequestMapping("/api/course")
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Secured("ROLE_USER")
    @GetMapping(path="/getAll")
    public Response getAll(){
        return new Response(true, "All courses", courseService.getAll());
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path="/create")
    public Response createCourse(@RequestBody Course course){
        return new Response(true, "Course created", courseService.createCourse(course));
    }
    @Secured("ROLE_USER")
    @GetMapping(path = "/getById/{id}")
    public Response getById(@PathVariable Long id){
        return new Response(true, "Course with id = " + id, courseService.getCourseById(id));
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete/{id}")
    public Response delete(@PathVariable Long id){
        courseService.deleteById(id);
        return new Response(true, "Course with id = " + id + " was deleted!", null);
    }
}
