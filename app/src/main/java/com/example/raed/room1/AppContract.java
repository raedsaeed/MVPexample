package com.example.raed.room1;

import com.example.raed.room1.data.User;

import java.util.List;

/**
 * Created by raed on 12/29/17.
 */

/**
 * This is {@link AppContract} that contain all interfaces needed to be used in View and Presenter
 */
public interface AppContract {

    /**
     * View interface is used in {@link ActivityView} to be a part of
     * communication between View and Presenter.
     * It's contain two methods
     * 1- showUser that show all the users returned back from Room
     * 2- setTitle i used this method for only testing so i didn't use it much
     */

    interface View {
        void showUsers(List<User> users);

        void setTitle (String name);

    }

    /**
     * Presenter interface is used in {@link ActivityPresenter} to be a part of communication
     * between View and Presenter, Presenter and Model.
     * It's contain three methods
     * 1- SaveUser when i add some user it return the Id of the new User.
     * 2- deleteUser with integer userId as parameter to delete a specific user.
     * 3- getAllUsers which get a list of Users stored in database.
     */
    interface Presenter {
        long saveUser (User user);


        void deleteUser (int userId);

        List<User> getAllUsers ();

    }
}
