package edu.morphia.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Name : Publisher
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
public class Publisher {

    @Id
    private ObjectId id;
    private String name;

    public Publisher() {
    }

    public Publisher(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}