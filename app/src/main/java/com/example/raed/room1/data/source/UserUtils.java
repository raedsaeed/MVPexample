package com.example.raed.room1.data.source;

import android.content.Context;
import android.util.Log;

import com.example.raed.room1.data.User;
import com.example.raed.room1.data.source.model.AppDatabase;

import java.util.List;


/**
 * Created by raed on 1/16/18.
 */

public class UserUtils {
    private static final String TAG = "UserUtils";
    public static long insertUser (Context context, User user) {
        Log.d(TAG, "insertUser: inserted");
       return AppDatabase.getInstance(context).userDao().addUser(user);
    }

    public static List<User> getAllUsers (Context context) {
        Log.d(TAG, "getAllUsers: called");
        return AppDatabase.getInstance(context).userDao().getAll();
    }

    public static User findUserByName (Context context, String firstName, String lastName) {
        return AppDatabase.getInstance(context).userDao().findByName(firstName, lastName);
    }

    public static void deleteUserById (Context context, int userId) {
        AppDatabase.getInstance(context).userDao().deleteUserById(userId);
    }

    public static void deleteAllUsers (Context context){
        AppDatabase.getInstance(context).userDao().deleteAllUsers();
    }
}
