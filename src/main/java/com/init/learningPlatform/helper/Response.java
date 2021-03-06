package com.init.learningPlatform.helper;

import com.init.learningPlatform.model.UserRole;

import java.util.List;

public class Response {
    Boolean isSuccessful;
    String message;
    Object object;
    List<UserRole> userRole;
    public Response(){}

    public Response(Boolean isSuccessful, String message, Object object, List<UserRole> userRole) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.object = object;
        this.userRole = userRole;
    }
    public Response(Boolean isSuccessful, String message, Object object) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.object = object;
    }

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }
}
