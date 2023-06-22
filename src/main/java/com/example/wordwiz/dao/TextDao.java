
package com.example.wordwiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TextDao implements AutoCloseable {
    private static final String GET_ALL_TEXTS = """
            SELECT text_id, fragment, author, title
            from texts
            order BY title """;

    private static final String GET_ONE_TEXT = """
            SELECT text_id, fragment, author, title
            from texts
            where text_id = ? """;

    private static final String GET_ENTRY = """
            SELECT text_id, fragment, author, title
            from texts
            where fragment like ? """;

    private Connection connection;

    public TextDao(DataSource ds) {

        try {
            this.connection = ds.getConnection();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public List<Text> getAllSortedByTitle() {
        List<Text> result = new ArrayList<>();

        try (Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery(GET_ALL_TEXTS)) {
            while (rs.next()) {

                Text text = new Text(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                result.add(text);

            }

        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
        return result;
    }

    public Text getText(int id) {

        try (PreparedStatement stmt = connection.prepareStatement(GET_ONE_TEXT)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Text text = new Text(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    return text;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public List<Text> getEntry(String entry) {
        List<Text> result = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(GET_ENTRY)) {
            String pattern = "%" + entry + "%";
            stmt.setString(1, pattern);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Text text = new Text(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    result.add(text);
                }
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
