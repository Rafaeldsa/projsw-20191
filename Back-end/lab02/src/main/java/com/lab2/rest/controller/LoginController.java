package com.lab2.rest.controller;


import com.lab2.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    private final String TOKEN_KEY = "banana";

    @Autowired
    private UserService userService;


}
