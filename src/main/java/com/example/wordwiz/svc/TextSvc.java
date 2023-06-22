
package com.example.wordwiz.svc;

import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Text;
import com.example.wordwiz.dao.TextDao;

public class TextSvc {
    private DataSource ds;

    public TextSvc(DataSource ds) {
        this.ds = ds;
    }

    public List<Text> getAllTexts() {

        try (TextDao dao = new TextDao(ds)) {
            return dao.getAllSortedByTitle();
        }  
    }

    public Text getText(int id) {

        try (TextDao dao = new TextDao(ds)) {
            return dao.getText(id);
        }  
    }
    
    public List<Text> getEntry(String entry) {

        try (TextDao dao = new TextDao(ds)) {
            return dao.getEntry(entry);
        }  
    }
    
}
