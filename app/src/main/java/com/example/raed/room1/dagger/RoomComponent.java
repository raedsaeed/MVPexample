package com.example.raed.room1.dagger;

import com.example.raed.room1.ActivityPresenter;
import com.example.raed.room1.ActivityView;

import dagger.Component;

/**
 * Created by raed on 2/13/18.
 */

@RoomScope
@Component (modules = {PresenterModule.class})
public interface RoomComponent {
    void inject(ActivityView activityView);
}
