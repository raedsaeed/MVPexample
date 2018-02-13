package com.example.raed.room1.dagger;

import android.content.Context;

import com.example.raed.room1.ActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raed on 2/13/18.
 */

@Module (includes = {ContextModule.class})
public class PresenterModule {

    @Provides
    @RoomScope
    public ActivityPresenter myPresenter (Context context) {
        return new ActivityPresenter(context);
    }
}
