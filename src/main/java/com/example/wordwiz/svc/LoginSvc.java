package com.example.wordwiz.svc;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.dao.UserDao;

public class LoginSvc {

	public User getUser(DataSource ds, String username, String password) {
		try (UserDao dao = new UserDao(ds)) {
			return dao.get(username, password);
		}
	}
}