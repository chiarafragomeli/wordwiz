
package com.example.wordwiz.svc;

import java.util.List;
import java.util.ArrayList;

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

    public List<Integer> indexesEntries(String fragment, String word) {
        List<Integer> indexes = new ArrayList<Integer>();
        String lowerCaseTextString = fragment.toLowerCase();
        String lowerCaseWord = word.toLowerCase();

        int index = 0;
        while (index != -1) {
            index = lowerCaseTextString.indexOf(lowerCaseWord, index);
            if (index != -1) {
                indexes.add(index);
                index++;
            }
        }
        return indexes;
    }

    public List<Text> getEntry(String entry) {
        if (entry == null || entry.isBlank()) {
            throw new IllegalArgumentException("I cannot search for an empty string.");
        }

        try (TextDao dao = new TextDao(ds)) {
            List<Text> texts = dao.getEntry(entry); 
            List<Text> results = new ArrayList<Text>(); 

            for (Text text : texts) {

                String fragment = text.getFragment();

                String[] splits = fragment.split("[.!?]");

                for (String split : splits) {

                    if (split.toLowerCase().contains(entry.toLowerCase())) {

                        String context = split.replace(entry.toLowerCase(), "<strong>"+entry+"</strong>");

                        Text result = new Text();
                        result.setId(text.getId());
                        result.setAuthor(text.getAuthor());
                        result.setTitle(text.getTitle());
                        result.setFragment(context.concat("."));
                        results.add(result);
                    }
                }
            }
            return results;
        }

    }
}
