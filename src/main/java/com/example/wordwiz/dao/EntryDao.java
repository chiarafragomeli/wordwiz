package com.example.wordwiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EntryDao implements AutoCloseable {

    private static final String INSERT_ENTRY = """
            INSERT INTO entries (entry_word, description, class_id, user_id)
            VALUES (?, ?, ?, ?) """;

    private static final String GET_ALL_ENTRIES_USER = """
            SELECT entry_id, entry_word, description, class_id
            FROM entries
            WHERE user_id = ?; """;

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

    public List<Entry> getAllEntriesUser(int userId) {
        List<Entry> result = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(GET_ALL_ENTRIES_USER)) {
                stmt.setInt(1, userId);

                ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Entry entry = new Entry(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), userId);
                result.add(entry);
            
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
        return result;
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
