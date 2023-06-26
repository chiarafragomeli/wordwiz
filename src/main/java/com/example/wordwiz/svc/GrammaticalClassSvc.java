package com.example.wordwiz.svc;

import java.util.Map;

import javax.sql.DataSource;

import com.example.wordwiz.dao.GrammaticalClassDao;

public class GrammaticalClassSvc {
    private DataSource ds;

    public GrammaticalClassSvc(DataSource ds) {
        this.ds = ds;
    }

    public Map<Integer, String> getAll() {
        try (GrammaticalClassDao dao = new GrammaticalClassDao(ds)) {
            return dao.getAll();
        } catch (Exception e) {
            return null;
        }
    }
}