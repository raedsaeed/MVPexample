package com.example.raed.room1.data.source.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.raed.room1.data.Book;
import com.example.raed.room1.data.User;

/**
 * Created by raed on 12/28/17.
 */

/**
 * Represented As The Model In MVP Architecture Pattern.
 * And Only Accessed Using Presenter.
 *
 * @Database Marks the class as a Room Database.
 * The class should be an abstract class and extends RoomDatabase.
 * {@link User} and {@link Book} are classes that annotated with @Entity and declared
 * as two tables within the Database
 */
@Database(entities = {User.class, Book.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    // Abstract instance of UserDao and used to allow abstract the database communications
    public abstract UserDao userDao ();

    // Static instance of AppDatabase
    private static AppDatabase instance;

    /**
     * static method that create the {@link AppDatabase} instance
     * @param context that is used to build the RoomDatabase
     * @return an instance of the AppDatabase
     */
    public static AppDatabase getInstance (Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class,
                    "userdatabase")
                    .build();
        }
        return instance;
    }
}


