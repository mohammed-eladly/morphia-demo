package edu.morphia;

import com.mongodb.AggregationOptions;
import com.mongodb.MongoClient;
import edu.morphia.model.Author;
import edu.morphia.model.Book;
import edu.morphia.model.Publisher;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Iterator;
import java.util.List;

import static org.mongodb.morphia.aggregation.Group.grouping;
import static org.mongodb.morphia.aggregation.Group.push;

/**
 * Name : Main
 * <p>
 * Description :
 * <p>
 * Date : 02/06/2021
 * <p>
 * Create by : Mohammed ElAdly
 * <p>
 * Mail : mohammed.eladly@afaqy.com
 */
public class Main {

    static Datastore datastore;

    public static void main(String[] args) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("edu.morphia.model");

        datastore = morphia.createDatastore(new MongoClient(), "library");
        datastore.ensureIndexes();

        saveNewBook("java");
        saveNewBook("math");
        saveNewBook("ds");

        printAllBooks();

        getBookByTitle("java");

        //todo: Book by id


        //todo: update book

    }

    private static void getBookByTitle(String title) {

        System.out.println("Get Book: " + title);
        List<Book> books = datastore.createQuery(Book.class).field("title").equal(title).asList();

        for(Book book : books) {
            System.out.println(book);
            System.out.println();
        }
    }

    private static void printAllBooks() {
        List<Book> books = datastore.createQuery(Book.class).asList();
        for(Book book : books) {
            System.out.println(book);
            System.out.println();
        }
    }

    private static void saveNewBook(String bookTitle) {
        Publisher publisher = new Publisher(new ObjectId(), "Awsome Publisher");

        Book book = new Book(new ObjectId(), bookTitle, "Tom Kirkman", 3.95, publisher);

        Book companionBook = new Book(new ObjectId(), "Java Performance Companion", "Tom Kirkman", 1.95, publisher);

        book.getCompanionBooks().add(companionBook);

        datastore.save(companionBook);
        datastore.save(book);
    }

}