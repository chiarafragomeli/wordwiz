package com.example.wordwiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class EntryDao implements AutoCloseable {

    private static final String INSERT_ENTRY = """
             INSERT INTO entries (entry_word, description, class_id, user_id)
             VALUES (?, ?, ?, ?) """;
    
    private Connection connection;
    
    public EntryDao(DataSource ds) {

        try {
            this.connection = ds.getConnection();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public boolean save(String entry, String description, int classId, int userId) {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_ENTRY)) {
            stmt.setString(1, entry);
            stmt.setString(2, description);
            stmt.setInt(3, classId);
            stmt.setInt(4, userId);

            int count = stmt.executeUpdate();
            return count == 1;
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
}
