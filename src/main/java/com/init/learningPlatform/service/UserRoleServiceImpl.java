package com.init.learningPlatform.service;

import com.init.learningPlatform.model.UserRole;
import com.init.learningPlatform.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public List<UserRole> getRolesByUserId(Long id) {
        return userRoleRepository.findAll().stream().filter(x-> x.getUser().getId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public List<UserRole> getRolesByRolename(String role) {
        return userRoleRepository.findAll().stream().filter(x->x.getRole().equals(role)).collect(Collectors.toList());
    }

    @Override
    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}
