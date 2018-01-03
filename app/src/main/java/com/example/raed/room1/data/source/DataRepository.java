package com.example.raed.room1.data.source;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.raed.room1.data.User;
import com.example.raed.room1.data.source.model.AppDatabase;

import java.util.List;

/**
 * Created by raed on 12/29/17.
 */

public class DataRepository implements DataSource.UserOperation{

    private AppDatabase database;

    public DataRepository (Context context) {
        database = AppDatabase.getInstance(context);
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public void removeAllUsers() {

    }

    @Override
    public long addUser(User user) {
        return 0;
    }
}
