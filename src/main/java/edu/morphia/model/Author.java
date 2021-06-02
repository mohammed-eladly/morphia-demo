package edu.morphia.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

/**
 * Name : Author
 * <p>
 * Description :
 * <p>
 * Date : 02/06/2021
 * <p>
 * Create by : Mohammed ElAdly
 * <p>
 * Mail : mohammed.eladly@afaqy.com
 */
@Entity
public class Author {

    @Id
    private String name;
    private List<String> books;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

}