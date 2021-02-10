package com.init.learningPlatform.controller;

import com.init.learningPlatform.helper.Response;
import com.init.learningPlatform.helper.UserWrapper;
import com.init.learningPlatform.model.User;
import com.init.learningPlatform.repository.CourseRepository;
import com.init.learningPlatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CourseRepository courseRepository;

    @Secured("ROLE_USER")
    @GetMapping(path = "/getAll")
    public Response getAll(){
        return new Response(true, "All registered users", userService.getAll());
    }


    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/create")
    public Response createUser(@RequestBody UserWrapper userWrapper){
        try{
            User user = new User.Builder(userWrapper.getUsername())
                    .withGender(userWrapper.getGender())
                    .withPassword(userWrapper.getPassword())
                    .withEmail(userWrapper.getEmail())
                    .isActive(userWrapper.getIsActive())
                    .build();
            return new Response(true, "New user created!", userService.createUser(user));
        }
        catch (NullPointerException ex){
            return new Response(false, "Some fields were empty!", ex.getStackTrace());
        }
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/update/{id}")
    public Response updateUser(@RequestBody User user){
        return new Response(true, "User updated!", userService.updateUser(user));
    }
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/get/{id}")
    public Response getUserById(@PathVariable Long id){
        return new Response(true, "Information about User with id = " + id, userService.getUserById(id));
    }
    @Secured("ROLE_USER")
    @GetMapping(path = "/getByCourseId/{id}")
    public Response getByCourseId(@PathVariable Long id){
        return new Response(true, "All users of the course with id = " + id, userService.getUsersByCourse(courseRepository.findById(id).get()));
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete/{id}")
    public Response deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return new Response(true, "User with id = " + id + " was deleted!", null );
    }
//    @Secured("ROLE_USER")
//    @PostMapping(path = "/changePassword")
//    public Response changePassword(@RequestBody PasswordWrapper passwordWrapper, Principal principal){
//        passwordWrapper.setUser(userService.getUserByUsername(principal.getName()));
//        return new Response(true,"Password changed successfully", userService.changePassword(passwordWrapper));
//    }
}
