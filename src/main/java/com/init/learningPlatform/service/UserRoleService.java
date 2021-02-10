package com.init.learningPlatform.service;

import com.init.learningPlatform.model.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAll();
    List<UserRole> getRolesByUserId (Long id);
    UserRole createUserRole(UserRole userRole);
    void deleteUserRole(Long id);
    List<UserRole> getRolesByRolename(String role);
}
