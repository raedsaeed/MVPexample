package com.example.raed.room1.dagger;


import com.example.raed.room1.ActivityPresenter;
import com.example.raed.room1.ActivityView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raed on 2/13/18.
 */

@Module (includes = {ContextModule.class})
public class PresenterModule {

    @Provides
    @RoomScope
    public ActivityPresenter myPresenter (@ContextQualifier ActivityView context) {
        return new ActivityPresenter(context);
    }
}
