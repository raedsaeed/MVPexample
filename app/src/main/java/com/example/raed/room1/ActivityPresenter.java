package com.example.raed.room1;

import android.content.Context;

import com.example.raed.room1.data.User;
import com.example.raed.room1.data.source.model.AppDatabase;

import java.util.List;


/**
 * Created by raed on 12/29/17.
 */


/**
 * Represent the Presenter of MVP architecture pattern and implements {@link AppContract.Presenter}
 * This class is brain of the app and consider as a bridge between View and Model and responsible for sending the updates to the
 * View class, get the user actions from it and perform other operations on Model.
 */
public class ActivityPresenter implements AppContract.Presenter {
    private static final String TAG = "ActivityPresenter";

    // An instance from AppDatabase
    private AppDatabase database;

    // AppContract.View interface instance
    private AppContract.View viewData;

    // Constructor of ActivityPresenter
    public ActivityPresenter (Context context) {
        // Initialize database instance
        database = AppDatabase.getInstance(context);
        // Initialize viewData interface by casting it fromm the context
        viewData = (AppContract.View) context;
    }

    /**
     * A method for calling addUser method using database instance
     * @param user the object to be inserted into the database
     * @return the id of the new row
     */
    @Override
    public long saveUser(User user) {
        if (user != null) {
            return database.userDao().addUser(user);
        }
        return 0;
    }

    /**
     * A method for delete a row from the database
     * @param userId the id of the row.
     */
    @Override
    public void deleteUser(int userId) {
        database.userDao().deleteUserById(userId);
    }

    /**
     * A query method to get all the data from the database
     * @return a list of Users
     */
    @Override
    public List<User> getAllUsers() {
       viewData.showUsers(database.userDao().getAll());
       return null;
    }
}
