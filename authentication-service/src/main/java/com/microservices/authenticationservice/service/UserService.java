package com.microservices.authenticationservice.service;

import com.microservices.authenticationservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User addUser(User user);
    public String authenticate(String username, String password);

}
