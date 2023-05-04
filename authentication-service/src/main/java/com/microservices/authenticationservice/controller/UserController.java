package com.microservices.authenticationservice.controller;

import com.microservices.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users/login/{username}/{password}")
    public String authenticate(@PathVariable String username, @PathVariable String password){
        return userService.authenticate(username, password);
    }
}
