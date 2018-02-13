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

        RoomComponent component =  DaggerRoomComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        presenter = component.getPresenter();
        presenter2 = component.getPresenter();

        Log.i(TAG, "onCreate: presenter " + presenter);
        Log.i(TAG, "onCreate: presenter2 " + presenter2);
    }
}
