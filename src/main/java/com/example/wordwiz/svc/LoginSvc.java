package com.example.wordwiz.svc;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.dao.UserDao;

public class LoginSvc {
    private DataSource ds;

    public LoginSvc(DataSource ds) {
        this.ds = ds;
    }

    public User get(String username, String password) {
        try (UserDao dao = new UserDao(ds)) {
            return dao.get(username, password);
        }
    }
    
    public User login(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty!");
        } else if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }
        try (UserDao dao = new UserDao(ds)) {
            User user = dao.get(username, password);
            if (user == null) {
                throw new IllegalArgumentException("Incorrect username or password!");
            }
            return user;
        }
    }
}