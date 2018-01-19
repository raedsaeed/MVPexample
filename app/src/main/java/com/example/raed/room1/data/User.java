package com.example.raed.room1.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.net.URI;

/**
 * Created by raed on 12/28/17.
 */

/**
 * Create table called users has and index is {uid, first_name and last_name}
 * NOTE adding index to table will speed up your queries but will slow down other database
 * operation such as insert or update.
 */

@Entity(tableName = "users", indices = {@Index(value = "uid"),
        @Index(value = {"first_name", "last_name"}, unique = true)})
public class User {

    // First Column in table called uid and will represented as uid INTEGER PRIMARY KEY AUTO INCREMENT
    // You can specify any column name using annotation @ColumnInfo (name = "Some Text")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private int userId;

    // Second Column in table called first_name will represented as first_name TEXT NOT NULL
    @ColumnInfo(name = "first_name")
    @NonNull
    private String firstName;

    // Third Column in table called last_name will represented as last_name TEXT NOT NULL
    @ColumnInfo(name = "last_name")
    @NonNull
    private String lastName;

    // Forth Column in table call level will represented as level INTEGER
    @ColumnInfo(name = "level")
    private int level;

    // Constructor of User class
    public User (@NonNull String firstName, @NonNull String lastName, int level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
    }

    // Getters and Setters
    @NonNull
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public int getLevel() {
        return level;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }

    /**
     * Overriding equals method to avoid duplicate objects if i want to insert it into a list
     * @param obj that should be measured
     * @return true if the object equals another object, false if the object not equals the parameter object
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof User)) {
            return false;
        }
        return ((User)obj).level == level &&
                ((User)obj).firstName.equals(firstName) &&
                ((User)obj).lastName.equals(lastName);
    }
}


















