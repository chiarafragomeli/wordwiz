package com.example.wordwiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class MessageDao implements AutoCloseable {

    private static final String INSERT_MESSAGE = """
            INSERT INTO messages (message, sender_id, recipient_id)
            VALUES (?, ?, 1) """;

    private static final String GET_ALL_MESSAGES_ORDERED = """
            SELECT message_id, message, time, sender_id
            FROM messages
            ORDER BY time """;

    private Connection connection;

    public MessageDao(DataSource ds) {

        try {
            this.connection = ds.getConnection();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public boolean saveMessage(String message, int userId) {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_MESSAGE)) {
            stmt.setString(1, message);
            stmt.setInt(2, userId);

            int count = stmt.executeUpdate();
            return count == 1;
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public List<Message> getAllSortedByTime() {
        List<Message> result = new ArrayList<>();

        try (Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery(GET_ALL_MESSAGES_ORDERED)) {
            while (rs.next()) {
                LocalDateTime time = rs.getTimestamp(3).toLocalDateTime();
                Message message = new Message(rs.getInt(1), rs.getString(2), time, rs.getInt(4), 1);
                result.add(message);
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
