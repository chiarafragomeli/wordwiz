package com.example.wordwiz.dao;

import java.util.Objects;

public class Text {

    private int id;
    private String fragment;
    private String author;
    private String title;

    public Text() {

    }

    public Text(int id, String fragment, String author, String title) {
        this.id = id;
        this.fragment = fragment;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, fragment, id, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Text other = (Text) obj;
        return Objects.equals(author, other.author) && Objects.equals(fragment, other.fragment) && id == other.id
                && Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
        return "Text [id=" + id + ", author=" + author + ", fragment=" + fragment + ", title=" + title + "]";
    }

}
