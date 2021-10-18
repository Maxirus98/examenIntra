package com.examenintraprojet.controllers;

import com.examenintraprojet.services.UserService;
import com.examenintraprojet.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam String email) {
        if(userService.getUser(email) != null)
            return new ResponseEntity<User>(userService.getUser(email), HttpStatus.OK);
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if(userService.getUser(user.getEmail()) == null)
            return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
        return new ResponseEntity<User>(HttpStatus.CONFLICT);
    }

    @PatchMapping
    public ResponseEntity<User> updateUser(@RequestParam String email) {
        return new ResponseEntity<User>(userService.updateUser(email), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam String email) {
        if(userService.getUser(email) != null) {
            userService.deleteUser(email);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/activate")
    public ResponseEntity<User> toggleUserActivity(@RequestParam String email, @RequestParam boolean isActive){
        if(userService.getUser(email) != null) {
            return new ResponseEntity<User>(userService.toggleUserActivity(email, isActive), HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
}
