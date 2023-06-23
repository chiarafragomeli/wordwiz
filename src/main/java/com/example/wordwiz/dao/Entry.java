package com.example.wordwiz.dao;

import java.util.Objects;

public class Entry {
    
    private int id;
    private String word;
    private String description;
    private int classId;
    private int userId;
    
    public Entry(int id, String word, String description, int classId, int userId) {
        this.id = id;
        this.word = word;
        this.description = description;
        this.classId = classId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, description, id, userId, word);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entry other = (Entry) obj;
        return classId == other.classId && Objects.equals(description, other.description) && id == other.id
                && userId == other.userId && Objects.equals(word, other.word);
    }

    @Override
    public String toString() {
        return "Entry [id=" + id + ", word=" + word + ", description=" + description + ", classId=" + classId
                + ", userId=" + userId + "]";
    }

    
}
