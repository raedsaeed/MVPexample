package com.example.raed.room1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.raed.room1.data.User;

import java.util.List;

public class ActivityView extends AppCompatActivity implements AppContract.View{

    private static final String TAG = "ActivityView";
    ActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new ActivityPresenter(this);
        addSomeUsers("Raed", "Saeed", 1);
        addSomeUsers("Mahmoud", "Saeed", 1);
        addSomeUsers("Nasser", "Saeed", 1);
    }

    @Override
    public void showUsers(List<User> userList) {
        for (User user : userList) {
            Log.d(TAG, "showUsers: " + user.getFirstName());
        }
    }

    @Override
    public void setTitle(String name) {
        Log.d(TAG, "setTitle: " + name);
    }

    private void addSomeUsers (final String name, final String lastName, final int level) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                presenter.saveUser(new User(name, lastName, level));
            }
        });
        thread.start();

    }

    public void onClick(View view) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    presenter.getAllUsers();
                }
            });
            thread.start();
    }
}
