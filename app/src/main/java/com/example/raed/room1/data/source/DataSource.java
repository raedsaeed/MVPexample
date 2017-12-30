package com.example.raed.room1.data.source;

import com.example.raed.room1.data.Book;
import com.example.raed.room1.data.User;

import java.util.List;

/**
 * Created by raed on 12/29/17.
 */

public interface DataSource {

    interface UserOperation {
        User getUserById (int id);

        List<User> getAllUsers ();

        void removeUser (int id);

        void removeAllUsers ();

        long addUser (User user);
    }

    interface BookOperation {
        Book getBookById (int id);

        List<Book> getAllBooks ();

        void removeBook (int id);

        void removeAllBooks ();

        long addBook (Book book);
    }

}
