package com.example.raed.room1.dagger;


import com.example.raed.room1.ActivityView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raed on 2/14/18.
 */

@Module
public class ContextModule {
    private ActivityView view;

    public ContextModule(ActivityView view) {
        this.view = view;
    }

    @Provides
    @RoomScope
    @ContextQualifier
    public ActivityView getActivityView() {
        return view;
    }
}
