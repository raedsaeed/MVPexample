package com.example.raed.room1.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by raed on 12/29/17.
 */

@Entity(tableName = "books",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "uid",
                childColumns = "user_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE), indices = { @Index(value = {"book_id", "user_id"})})
public class Book {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "book_id")
    private long id;

    @ColumnInfo (name = "book_name")
    private String bookName;

    @ColumnInfo (name = "user_id")
    private int userId;

    public Book(String bookName, int userId) {
        this.bookName = bookName;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return bookName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Book)) {
           return true;
       }else  {
           return ((Book) obj).getBookName().equals(bookName) &&
                   ((Book) obj).getUserId() == userId;
       }
    }
}
