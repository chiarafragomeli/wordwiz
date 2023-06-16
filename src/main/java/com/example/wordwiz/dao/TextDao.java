
package com.example.wordwiz.dao;

import java.sql.Connection;
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

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }

    }
}
