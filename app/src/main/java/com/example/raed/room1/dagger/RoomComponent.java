package com.example.raed.room1.dagger;

import com.example.raed.room1.ActivityPresenter;

import dagger.Component;

/**
 * Created by raed on 2/13/18.
 */

@Component (modules = {PresenterModule.class})
public interface RoomComponent {
    ActivityPresenter getPresenter();
}
