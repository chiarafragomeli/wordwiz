package com.example.wordwiz.svc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import com.example.wordwiz.dao.UserDao;

public class UpdateUserInfoSvc {
    private DataSource ds;

    public UpdateUserInfoSvc(DataSource ds) {
        this.ds = ds;
    }

    public boolean updateEmail(String email, int id) {
        try (UserDao dao = new UserDao(ds)) {
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email cannot be empty!");
            } else {
                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                if (!matcher.matches()) {
                    throw new IllegalArgumentException("Invalid email address!");
                }
            }
            return dao.updateEmail(email, id);
        }
    }

    public boolean updatePassword(String oldPassword, String newPassword, int id) {
        try (UserDao dao = new UserDao(ds)) {
            if (oldPassword == null || oldPassword.isBlank() || newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        } else if (newPassword.equals(oldPassword)) {
            throw new IllegalArgumentException("New password must be different from the old one!");
        } else if (dao.checkPassword(oldPassword, id)) {
                return dao.updatePassword(newPassword, id);
            }
        }
        return false;
    }
}
