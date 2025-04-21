package org.learningproject.Users.service;

import org.learningproject.Users.Repository.UserRepository;
import org.learningproject.Users.model.User;
import org.learningproject.Users.model.UserRole;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(String username, String email, String password){
        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(UserRole.USER);

        userRepository.save(user);
    }

    public String login(String email, String password){
        if(!userRepository.existsByEmail(email)){
            return "Email Not Found";
        }

        if(!userRepository.existsByPassword(password)){
            System.out.println("Password Not Found");
            return "Incorrect Password";
        }

        return "Login successful!";
    }
}
