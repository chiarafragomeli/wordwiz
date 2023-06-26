
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
        	List<Text> texts = dao.getEntry(entry);
        	for (Text text : texts) {
        		String fragment = text.getFragment();
        		int pos = fragment.indexOf(entry);
        		int begin = (pos < 50) ? 0 : (pos - 50);
        		int end = (pos + 50 < fragment.length()) ? (pos + 50) : (fragment.length() -1);
        		String sub = fragment.substring(begin, end);
        		text.setFragment("... " + sub + "...");
        	}
        	return texts;
        }  
    }
    
}
