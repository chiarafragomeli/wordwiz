package com.example.wordwiz.dao;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private int id;
    private String message;
    private LocalDateTime time;
    private int sender_id;
    private int recipient_id;

    public Message() {
    }

    public Message(int id, String message, LocalDateTime time, int sender_id, int recipient_id) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(int recipient_id) {
        this.recipient_id = recipient_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, recipient_id, sender_id, time);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        return id == other.id && Objects.equals(message, other.message) && recipient_id == other.recipient_id
                && sender_id == other.sender_id && Objects.equals(time, other.time);
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", message=" + message + ", time=" + time + ", sender_id=" + sender_id
                + ", recipient_id=" + recipient_id + "]";
    }

}
