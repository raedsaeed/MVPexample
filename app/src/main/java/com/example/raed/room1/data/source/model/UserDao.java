package com.example.raed.room1.data.source.model;

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
    /**
     * Select all users' rows from database
     * @return a list of Users
     */
    @Query("SELECT * FROM users")
    List<User> getAll();

    /**
     * Select a specific User
     * @param first first name of User
     * @param last last name of User
     * @return User object
     */
    @Query("SELECT * FROM users WHERE first_name LIKE :first AND last_name LIKE :last")
    User findByName(String first, String last);

    /**
     * Insert a User object into database
     * @param user that want to be inserted into database
     * @return the new Id of the new User.
     *
     * NOTE we Using @Insert (onConflict = OnConflictStrategy.REPLACE) to avoid duplicates rows
     */
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    long addUser (User user);

    /**
     * Delete a User using its id
     * @param userId the User Id
     */
    @Query("DELETE FROM users WHERE uid = :userId")
    void deleteUserById (int userId);

    /**
     * Delete All Users from the table.
     */
    @Query("DELETE FROM users")
    void deleteAllUsers ();

}
