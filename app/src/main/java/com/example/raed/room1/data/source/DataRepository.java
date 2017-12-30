package com.example.raed.room1.data.source;

import com.example.raed.room1.data.User;

import java.util.List;

/**
 * Created by raed on 12/29/17.
 */

public class DataRepository implements DataSource.UserOperation{

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
