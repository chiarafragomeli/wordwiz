package com.example.wordwiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDao implements AutoCloseable {
	private static final String GET_BY_USERNAME_AND_PASSWORD = """
			SELECT user_id, username, email
			FROM users
			WHERE username = ? AND password = ?""";
	private static final String SAVE_USERNAME_EMAIL_AND_PASSWORD = """
			INSERT INTO users (username, email, password) VALUES
			(?, ?, ?);""";

	private Connection connection;

	public UserDao(DataSource ds) {

		try {
			this.connection = ds.getConnection();
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
	}

	public User get(String username, String password) {
		try (PreparedStatement stmt = connection.prepareStatement(GET_BY_USERNAME_AND_PASSWORD)) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {

					return new User(rs.getInt(1), rs.getString(2), rs.getString(3));

				} else {
					return null;
				}
			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
	}

	public User save(String username, String email, String password) {
		try (PreparedStatement stmt = connection.prepareStatement(SAVE_USERNAME_EMAIL_AND_PASSWORD)) {
			stmt.setString(1, username);
			stmt.setString(2, email);
			stmt.setString(3, password);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {

					return new User(rs.getInt(1), rs.getString(2), rs.getString(3));

				} else {
					return null;
				}
			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
	}

	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}

	}
}
