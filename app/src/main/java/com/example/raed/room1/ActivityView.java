package com.example.raed.room1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.raed.room1.dagger.ContextModule;
import com.example.raed.room1.dagger.DaggerRoomComponent;
import com.example.raed.room1.dagger.RoomComponent;
import com.example.raed.room1.data.User;

import java.util.List;

import javax.inject.Inject;

/**
 * Represent the View of The MVP architecture pattern and implements {@link AppContract.View}
 * This class not doing very much it's only used to display the updates to the
 * user which in my case display the data returned back as A LOG messages.
 */
public class ActivityView extends AppCompatActivity implements AppContract.View, View.OnClickListener{

    private static final String TAG = "ActivityView";
    //Declare a member Variable ActivityPresenter
    @Inject
    ActivityPresenter presenter;
    //A button to get data from database
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the presenter
        RoomComponent component =  DaggerRoomComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        component.inject(this);

        // Initialize the button
        button = (Button)findViewById(R.id.show_data);
        button.setOnClickListener(this);

        // Insert some data into the database
        addSomeUsers("Raed", "Saeed", 1);
        addSomeUsers("Mahmoud", "Saeed", 1);
        addSomeUsers("Nasser", "Saeed", 1);
    }
    @Override
    public void showUsers(List<User> userList) {
        Log.d(TAG, "showUsers: " + userList.size());
        StringBuilder builder = new StringBuilder();
        for (User user : userList) {
            builder.append(user.getFirstName() + " " + user.getLastName() + " level : " + user.getLevel() +'\n');
        }
        Log.d(TAG, "showUsers: " + builder.toString());
    }

    /**
     * I used it before for testing but now it does nothing.
     * @param name don't care about it :)
     */
    @Override
    public void setTitle(String name) {
        Log.d(TAG, "setTitle: " + name);
    }

    /**
     * A helper method to insert some data in database.
     * @param name the name of the user.
     * @param lastName the last name of the user.
     * @param level the level of the user.
     *
     * NOTE we can't insert data on the UI main thread hence we need a separate thread to
     * preform this job for us and i used a very simple thread to do it.
     */
    private void addSomeUsers (final String name, final String lastName, final int level) {
        //Declare a new Thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Call saveUser method to insert the user into database on a separate thread.
                presenter.saveUser(new User(name, lastName, level));
            }
        });
        //Start the thread.
        thread.start();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.show_data) {
            Log.d(TAG, "onClick: Clicked");
            // Declare a thread to get the users from the database
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    presenter.getAllUsers();
                }
            });
            // Start the thread.
            thread.start();
        }

    }
}
