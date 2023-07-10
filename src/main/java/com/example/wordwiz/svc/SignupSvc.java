package com.example.wordwiz.svc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import com.example.wordwiz.dao.UserDao;

public class SignupSvc {
    private DataSource ds;

    public SignupSvc(DataSource ds) {
        this.ds = ds;
    }

    public boolean saveUser(String username, String email, String password) {
        try (UserDao dao = new UserDao(ds)) {
            if (username == null || username.isBlank()) {
                throw new IllegalArgumentException("Username cannot be empty!");
            } else if (password == null || password.isBlank()) {
                throw new IllegalArgumentException("Password cannot be empty!");
            } else if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email cannot be empty!");
            } else {
                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                if (!matcher.matches()) {
                    throw new IllegalArgumentException("Invalid email address!");
                }
            }
            return dao.save(username, email, password);
        }
    }
}
