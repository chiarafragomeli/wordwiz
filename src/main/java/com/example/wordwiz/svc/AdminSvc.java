package com.example.wordwiz.svc;

import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.dao.AdminDao;
import com.example.wordwiz.dao.Entry;
import com.example.wordwiz.dao.EntryDao;

public class AdminSvc {


    private DataSource ds;

    public AdminSvc(DataSource ds) {
        this.ds = ds;
    }

    public List<User> getAllUsers() {

        try (AdminDao dao = new AdminDao(ds)) {
            return dao.get();
        }  
    }

    public List<Entry> getAllEntriesAdmin() {
        try (AdminDao dao = new AdminDao(ds)) {
            return dao.getAllEntriesAdmin();
        } catch (Exception e) {
            return null;
        }
    }       
}


