package edu.morphia.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Name : Book
 * <p>
 * Description :
 * <p>
 * Date : 02/06/2021
 * <p>
 * Create by : Mohammed ElAdly
 * <p>
 * Mail : mohammed.eladly@afaqy.com
 */
@Entity("Books")
public class Book {

    @Id
    private ObjectId id;
    private String title;
    private String author;
    @Property("price")
    private double cost;

    @Embedded
    private Publisher publisher;

    @Reference
    private List<Book> companionBooks = new ArrayList<>();

    public Book() {
    }

    public Book(ObjectId id, String title, String author, double cost, Publisher publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.publisher = publisher;
    }

    public Book(ObjectId id, String title, String author, double cost, Publisher publisher, List<Book> companionBooks) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.publisher = publisher;
        this.companionBooks = companionBooks;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Book> getCompanionBooks() {
        return companionBooks;
    }

    public void setCompanionBooks(List<Book> companionBooks) {
        this.companionBooks = companionBooks;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", cost=" + cost
                + ", publisher=" + publisher + ", companionBooks=" + companionBooks + '}';
    }

}