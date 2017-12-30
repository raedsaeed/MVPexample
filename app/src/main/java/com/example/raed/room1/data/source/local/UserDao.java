package com.example.raed.room1.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.raed.room1.data.User;

import java.util.List;

/**
 * Created by raed on 12/28/17.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

//    @Query("SELECT * FROM users WHERE Id IN (:userIds)")
//    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND last_name LIKE :last")
    User findByName(String first, String last);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    long addUser (User user);

    @Query("DELETE FROM users WHERE uid = :userId")
    void deleteUserById (int userId);

    @Query("DELETE FROM users")
    void deleteAllUsers ();

}
