package com.example.calhamnorthway.group17projectpart4;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.calhamnorthway.group17projectpart4.data.Gender;
import com.example.calhamnorthway.group17projectpart4.data.UserVO;
import com.example.calhamnorthway.group17projectpart4.fragments.MeetPeopleFragment;
import com.example.calhamnorthway.group17projectpart4.fragments.MessagingMatchesFragment;

import java.util.ArrayList;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
        implements MeetPeopleFragment.OnFragmentInteractionListener,
        MessagingMatchesFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    public NavController navController;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creates a new Saved Instance State Bundle if null
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();

        //Sets up the view content and the action bar
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Sets up the drawer layout and navigation view
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.drawer_nav_view);

        //Sets up the Navigation system and sets it up to work well with the drawer layout
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Sets up the AppBar Configuration for the Navigation UI. Sets the meetPeopleFragment and
        // MessagingMatchesFragment as top level in destinations
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.meetPeopleFragment, R.id.messagingMatchesFragment)
                .setDrawerLayout(drawerLayout)
                .build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);

        //Sets up the NavigationView with the NavController and sets up a listener to lock the drawer layout
        //if the current shown fragment is not a top level destination
        NavigationUI.setupWithNavController(navigationView, navController);
        navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
            @Override
            public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {

                Log.d(TAG, "onNavigated: " + destination.getId());
                if(R.id.meetPeopleFragment == destination.getId()
                        || R.id.messagingMatchesFragment == destination.getId()) {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                } else {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
            }
        });

        //Instantiate User Array for app
        ArrayList<UserVO> allUsers = new ArrayList<>();

        //Create user
        UserVO calham = new UserVO("Calham Northway", 21, Gender.Male, "Sexxxier than the Dos Equis guy.", null, null);
        UserVO brianna = new UserVO("Brianna Marshinew", 21, Gender.Female, "I like long walks on the beach.", null, null);
        UserVO michael = new UserVO("Michael CY", 22, Gender.Male, "We can hang.", null, null);
        UserVO chris = new UserVO("Chris Beda", 26, Gender.Male, "Banned from Christian Mingle", null, null);

        //Add user to arrayList
        allUsers.add(calham);
        allUsers.add(brianna);
        allUsers.add(chris);
        allUsers.add(michael);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onGoToProfile() {
        navController.navigate(R.id.action_meetPeopleFragment_to_profileDetailsFragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
