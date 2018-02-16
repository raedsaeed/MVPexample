package com.example.raed.room1.dagger;

import android.app.Application;
import android.util.Log;

import com.example.raed.room1.ActivityPresenter;


/**
 * Created by raed on 2/14/18.
 */

public class RoomApplication extends Application {
    private static final String TAG = "RoomApplication";
    ActivityPresenter presenter;
    ActivityPresenter presenter2;
    @Override
    public void onCreate() {
        super.onCreate();


    }
}
