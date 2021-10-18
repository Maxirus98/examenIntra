package com.examenintraprojet.services;

import com.examenintraprojet.repositories.UserRepository;
import com.examenintraprojet.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String email){
        return userRepository.findUserByEmail(email);
    }

    public User addUser(User user){
       return this.userRepository.save(user);
    }

    public User updateUser(String email){
        User user = this.userRepository.findUserByEmail(email);
        // UPDATE HERE
        return this.userRepository.save(user);
    }

    public void deleteUser(String email){
        User user = this.userRepository.findUserByEmail(email);
        this.userRepository.delete(user);
    }

    public User toggleUserActivity(String email, boolean isActive){
        User user = this.userRepository.findUserByEmail(email);
        user.setIsActive(isActive);
        return this.userRepository.save(user);
    }
}
