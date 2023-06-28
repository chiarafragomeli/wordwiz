package com.example.wordwiz.svc;

import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Message;
import com.example.wordwiz.dao.MessageDao;

public class MessageSvc {
    private DataSource ds;
    
    public MessageSvc(DataSource ds) {
        this.ds = ds;
    }
    
    public boolean saveMessage(String message, int userId) {
        if (message == null) {
            return false;
        }
        try (MessageDao dao = new MessageDao(ds)) {
            return dao.saveMessage(message, userId);
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Message> getAllMessages() {
        try (MessageDao dao = new MessageDao(ds)) {
            return dao.getAllSortedByTime();
        } catch (Exception e) {
            return null;
        }  
    }

}
