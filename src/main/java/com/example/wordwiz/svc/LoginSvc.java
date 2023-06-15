package com.example.wordwiz.svc;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.dao.UserDao;

public class LoginSvc {
    private DataSource ds;

	public LoginSvc(DataSource ds) {
        this.ds = ds;
    }

    public User getUser(String username, String password) {
		try (UserDao dao = new UserDao(ds)) {
			return dao.get(username, password);
		}
	}
	
	public boolean saveUser(String username, String password, String email) {
	    if(username == null || username.isBlank() || password == null || password.isBlank() || email == null || email.isBlank() ) {
	        return false;
	    }
	    try (UserDao dao = new UserDao(ds)) {
            return dao.save(username, password, email);
        }
	}
}