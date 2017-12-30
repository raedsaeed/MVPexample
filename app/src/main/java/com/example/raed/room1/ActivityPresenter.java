package com.example.raed.room1;

import android.content.Context;

import com.example.raed.room1.data.User;
import com.example.raed.room1.data.source.local.AppDatabase;

import java.util.List;


/**
 * Created by raed on 12/29/17.
 */

public class ActivityPresenter implements AppContract.Presenter {
    private static final String TAG = "ActivityPresenter";

    private AppDatabase database;
    private AppContract.View viewData;

    public ActivityPresenter (Context context) {
        database = AppDatabase.getInstance(context);
        viewData = (AppContract.View) context;
    }

    @Override
    public long saveUser(User user) {
        if (user != null) {
            return database.userDao().addUser(user);
        }
        return 0;
    }

    @Override
    public void deleteUser(int userId) {
        database.userDao().deleteUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> data =  database.userDao().getAll();
        viewData.showUsers(data);
        return data;
    }
}
