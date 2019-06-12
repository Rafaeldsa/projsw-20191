package com.lab2.rest.controller;

import com.lab2.rest.model.User;
import com.lab2.rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    UserController(UserService productService) {
        this.userService = userService;
    }

    @PostMapping(value="/")
    public ResponseEntity<User> create(@RequestBody User user) {
        User newUser = userService.create(user);

        if (newUser == null) {
            throw new InternalError("Something went wrong");
        }

        return new ResponseEntity<User>((User) newUser, HttpStatus.CREATED);
    }



}
