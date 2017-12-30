package com.example.raed.room1;

import com.example.raed.room1.data.User;

import java.util.List;

/**
 * Created by raed on 12/29/17.
 */

public interface AppContract {

    interface View {
        void showUsers(List<User> users);

        void setTitle (String name);

    }

    interface Presenter {
        long saveUser (User user);


        void deleteUser (int userId);

        List<User> getAllUsers ();

    }
}
