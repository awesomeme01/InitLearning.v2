package com.init.learningPlatform.bootstrap;

import com.init.learningPlatform.helper.CourseStatusEnum;
import com.init.learningPlatform.helper.GenderEnum;
import com.init.learningPlatform.model.Course;
import com.init.learningPlatform.model.User;
import com.init.learningPlatform.model.UserRole;
import com.init.learningPlatform.service.CourseService;
import com.init.learningPlatform.service.UserRoleService;
import com.init.learningPlatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;

public class MainBootstrap implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    CourseService courseService;
    @Override
    public void run(String... args) throws Exception {

        Course course1 = new Course("Java", LocalDateTime.now(),2.5, CourseStatusEnum.PLANNING);
        Course course2 = new Course("Javascript", LocalDateTime.now(), 2.5, CourseStatusEnum.PLANNING);
        Course course3 = new Course("Python", LocalDateTime.now(), 2.5, CourseStatusEnum.IN_PROGRESS);

        courseService.createCourse(course1);
        courseService.createCourse(course2);
        courseService.createCourse(course3);

        User user1 = new User.Builder("admin").withGender(GenderEnum.MALE).withPassword("1267476").withPhoneNumber("996555348520").withEmail("gijdjd@gmail.com").isActive(1).build();

        userService.createUser(user1);
        UserRole userRole1 = new UserRole(user1,"ROLE_ADMIN");
        userRoleService.createUserRole(userRole1);

    }
}
