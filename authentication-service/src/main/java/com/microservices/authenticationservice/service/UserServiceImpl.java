package com.microservices.authenticationservice.service;

import com.microservices.authenticationservice.model.User;
import com.microservices.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String authenticate(String username, String password) {
        if (username.equals(userRepository.findByUsername(username).getUsername())){
            User user = userRepository.findByUsername(username);
            String password2 = user.getPassword();
            if (password.equals(password2)){
                return "Hi " + user.getName() + "!. You're successfully logged in.";
            }
        }
        return "Incorrect username/password!!";
    }
}
