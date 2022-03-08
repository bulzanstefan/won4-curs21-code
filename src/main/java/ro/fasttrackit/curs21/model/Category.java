package ro.fasttrackit.curs21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
