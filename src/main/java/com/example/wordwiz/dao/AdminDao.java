package com.example.wordwiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class AdminDao implements AutoCloseable {

    private static final String ALL_USERS_ADMIN = """
            select user_id, username, email
            from users """;

    private static final String GET_ALL_ENTRIES_ADMIN = """
            SELECT entry_id, entry_word, description, class_id
            FROM entries """;

    private Connection connection;

    public AdminDao(DataSource ds) {

        try {
            this.connection = ds.getConnection();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public List<User> get() {
        List<User> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(ALL_USERS_ADMIN)) {
            while (rs.next()) {

                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                result.add(user);
            }
        }

        catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
        return result;
    }

    public List<Entry> getAllEntriesAdmin() {
        List<Entry> result = new ArrayList<>();

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(GET_ALL_ENTRIES_ADMIN)) {
            while (rs.next()) {

                Entry entry = new Entry(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(4));
                result.add(entry);

            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
        return result;
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
