package com.lab2.rest.service;

import com.lab2.rest.dao.UserDAO;
import org.springframework.stereotype.Service;
import com.lab2.rest.model.User;

@Service
public class UserService {

    private final UserDAO userDAO;

    UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User create(User user) {
        User userVerify = findByLogin(user.getLogin());

        if (!(userVerify == null)){
            throw new RuntimeException("Could not create. The login already exist.");
        }
        return userDAO.save(user);
    }



    public User findByLogin(String userLogin) {
        return (userDAO.findByLogin(userLogin));
    }
}
