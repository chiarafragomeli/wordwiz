package com.example.wordwiz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class GrammaticalClassDao implements AutoCloseable {

    private static final String ALL_GRAMM_CLASS = """
            select class_id, name
            from gramm_class """;

    private Connection connection;

    public GrammaticalClassDao(DataSource ds) {

        try {
            this.connection = ds.getConnection();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public Map<Integer, String> getAll() {
        Map<Integer, String> result = new HashMap<>();

        try (Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery(ALL_GRAMM_CLASS)) {
            while (rs.next()) {

                result.put(rs.getInt(1), rs.getString(2));

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
