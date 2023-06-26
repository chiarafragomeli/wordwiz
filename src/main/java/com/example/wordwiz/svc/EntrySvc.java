package com.example.wordwiz.svc;

import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.EntryDao;
import com.example.wordwiz.dao.Entry;

public class EntrySvc {
    private DataSource ds;

    public EntrySvc(DataSource ds) {
        this.ds = ds;
    }

    public boolean saveEntry(String entry, String description, int classID, int userId) {
        if (entry == null) {
            return false;
        }
        try (EntryDao dao = new EntryDao(ds)) {
            return dao.save(entry, description, classID, userId);
        } catch (Exception e) {
            return false;
        }
    }

    // aggiungere try catch
    public List<Entry> getAllEntriesUser(int userId) {
        try (EntryDao dao = new EntryDao(ds)) {
            return dao.getAllEntriesUser(userId);
        } catch (Exception e) {
            return null;
        }
    }
}
