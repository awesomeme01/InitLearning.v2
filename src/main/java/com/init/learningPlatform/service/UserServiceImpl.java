package com.init.learningPlatform.service;

import com.init.learningPlatform.helper.PasswordWrapper;
import com.init.learningPlatform.model.Course;
import com.init.learningPlatform.model.User;
import com.init.learningPlatform.model.UserRole;
import com.init.learningPlatform.repository.UserRepository;
import com.init.learningPlatform.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByCourse(Course course) {
        return null;//TODO: start-finish
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        userRoleRepository.save(new UserRole(user, "ROLE_USER"));
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User changePassword(PasswordWrapper passwordWrapper) {
        passwordWrapper.getUser().setPassword(passwordWrapper.getNewPassword());
        return passwordWrapper.getUser();
    }
}
