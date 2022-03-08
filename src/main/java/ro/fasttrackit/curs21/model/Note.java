package ro.fasttrackit.curs21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private int id;
    private String author;
    private String text;

    public Note() {
    }

    public Note(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
