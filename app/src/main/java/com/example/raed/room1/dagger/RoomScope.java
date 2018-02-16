package com.example.raed.room1.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by raed on 2/14/18.
 */


/**
 * Scope annotation used to make sure there is only one instance of the Dependencies.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface RoomScope {
}
