package com.example.raed.room1.data.source.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.raed.room1.data.Book;

import java.util.List;

/**
 * Created by raed on 12/29/17.
 */

@Dao
public interface BookDao {

    @Query("SELECT * FROM books")
    List<Book> getAllBooks ();

    @Query("SELECT * FROM books WHERE user_id = :userId")
    List<Book> getBookById (int userId);

    @Query("SELECT * FROM books WHERE book_name LIKE :name")
    List<Book> getBooksByName (String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addBook (Book book);

    @Query("DELETE FROM books WHERE book_id = :bookId")
    void deleteBookById (int bookId);

}
