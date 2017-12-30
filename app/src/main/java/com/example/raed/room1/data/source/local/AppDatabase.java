package com.example.raed.room1.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.raed.room1.data.Book;
import com.example.raed.room1.data.User;

/**
 * Created by raed on 12/28/17.
 */

@Database(entities = {User.class, Book.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract UserDao userDao ();

    private static AppDatabase instance;

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


