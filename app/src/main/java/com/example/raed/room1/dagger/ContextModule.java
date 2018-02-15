package com.example.raed.room1.dagger;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raed on 2/14/18.
 */

@Module
public class ContextModule {
    private Context context;

    public ContextModule (Context context) {
        this.context = context;
    }

    @Provides
    @RoomScope
    @ContextQualifier
    public Context getContext () {
        return context;
    }
}
