package com.init.learningPlatform.service;

import com.init.learningPlatform.helper.PasswordWrapper;
import com.init.learningPlatform.model.Course;
import com.init.learningPlatform.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    List<User> getUsersByCourse(Course course);
    User createUser(User user);
    User updateUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    User getUserByUsername(String username);
    User changePassword(PasswordWrapper passwordWrapper);
}
