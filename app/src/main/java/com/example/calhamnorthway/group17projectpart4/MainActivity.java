package com.example.calhamnorthway.group17projectpart4;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.calhamnorthway.group17projectpart4.data.Conversation;
import com.example.calhamnorthway.group17projectpart4.data.Gender;
import com.example.calhamnorthway.group17projectpart4.data.Match;
import com.example.calhamnorthway.group17projectpart4.data.Message;
import com.example.calhamnorthway.group17projectpart4.data.Person;
import com.example.calhamnorthway.group17projectpart4.data.Profile;
import com.example.calhamnorthway.group17projectpart4.data.User;
import com.example.calhamnorthway.group17projectpart4.fragments.messaging.MessagingFragment;
import com.example.calhamnorthway.group17projectpart4.fragments.MeetPeopleFragment;
import com.example.calhamnorthway.group17projectpart4.fragments.MessagingMatchesFragment;
import com.example.calhamnorthway.group17projectpart4.fragments.ProfileDetailsFragment;
import com.example.calhamnorthway.group17projectpart4.fragments.matches.MatchesListFragment;
import com.example.calhamnorthway.group17projectpart4.fragments.messaging.ConversationsListFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
        implements MeetPeopleFragment.OnFragmentInteractionListener,
        ProfileDetailsFragment.OnFragmentInteractionListener,
        MessagingMatchesFragment.OnFragmentInteractionListener,
        ConversationsListFragment.OnConversationListFragmentInteractionListener,
        MatchesListFragment.OnMatchesListFragmentInteractionListener,
        MessagingFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    public NavController navController;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private AppBarConfiguration appBarConfiguration;

    private ArrayList<Person> peopleToMeet;
    private int personIndex = 0;

    private User mainUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creates a new Saved Instance State Bundle if null
        if (savedInstanceState == null)
            //noinspection UnusedAssignment
            savedInstanceState = new Bundle();

        //Sets up the view content and the action bar
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabs);
        showTabs(false);

        //Sets up the drawer layout and navigation view
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.drawer_nav_view);

        //Sets up the Navigation system and sets it up to work well with the drawer layout
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Sets up the AppBar Configuration for the Navigation UI. Sets the meetPeopleFragment and
        // MessagingMatchesFragment as top level in destinations
        appBarConfiguration = new AppBarConfiguration
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

        mainUser = new User("Main User", 20, Gender.Male,
                Profile.newBuilder()
                        .withPictureIds(R.drawable.img_mainuser)
                        .build());

        //Set up Matches
        ArrayList<Match> matches = new ArrayList<>();

        long hour = 1000 * 60 * 60;

        Date current = Calendar.getInstance().getTime();
        Date temp = new Date(current.getTime() - (hour * 461));
        matches.add(new Match(Person.people.get(0), temp));

        temp = new Date(current.getTime() - (hour * 52));
        matches.add(new Match(Person.people.get(3), temp));

        temp = new Date(current.getTime() - (hour * 2));
        matches.add(new Match(Person.people.get(6), temp));

        temp = new Date(current.getTime() - (hour * 216));
        matches.add(new Match(Person.people.get(9), temp));

        mainUser.setMatches(matches);

        //Set up people to meet
        peopleToMeet = new ArrayList<>();
        peopleToMeet.add(Person.people.get(1));
        peopleToMeet.add(Person.people.get(2));
        peopleToMeet.add(Person.people.get(4));
        peopleToMeet.add(Person.people.get(5));
        peopleToMeet.add(Person.people.get(7));
        peopleToMeet.add(Person.people.get(8));
        peopleToMeet.add(Person.people.get(10));

        //Set up Conversations
        ArrayList<Conversation> conversations = new ArrayList<>();

        Message message1 = new Message(Person.people.get(0), new Date(current.getTime()  - (hour + 10000)),
                "Hi Cutie");
        Message message2 = new Message(Person.people.get(0), new Date(current.getTime()  - (hour)),
                "This is a simple message for a simple person like you");
        Message message3 = new Message(mainUser, new Date(current.getTime()  - (hour - (1000 * 60 * 12))),
                "Thank you for the dms");
        Message message4 = new Message(Person.people.get(0), new Date(current.getTime()  - (hour - (1000 * 60 * 15))),
                "Your welcome hot stuff");

        conversations.add(new Conversation(Person.people.get(0), message1, message2, message3, message4));

        message1 = new Message(Person.people.get(6), new Date(current.getTime()  - (hour)),
                "Whats cooking good looking");
        message2 = new Message(Person.people.get(6), new Date(current.getTime()  - (hour - 10000)),
                "I rarely say this to anyone but you are one sexy person");

        conversations.add(new Conversation(Person.people.get(6), message1, message2));

        mainUser.setConversations(conversations);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void showTabs(boolean show) {
        if(show) {
            tabLayout.setVisibility(View.VISIBLE);
        } else {
            tabLayout.setVisibility(View.GONE);
        }
    }

    public void showActionBar(boolean show) {
        //Check if support action bar is not null
        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null) {
            return;
        }

        if(show) {
            actionBar.show();
        } else {
            actionBar.hide();
        }
    }

    public void setToolbar(Toolbar toolbar) {
        if(toolbar == null) {
            toolbar = this.toolbar;
            setSupportActionBar(this.toolbar);
            showActionBar(true);
        } else {
            showActionBar(false);
            setSupportActionBar(toolbar);
        }
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

    @Override
    public void onGoToProfile(Person person) {

    }

    @Override
    public User getMainUser(){
        return mainUser;
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow((null == getCurrentFocus()) ?
                null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }

    @Override
    public void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null) {
                actionBar.setTitle(title);
        }
    }

    @Override
    public void onGoToProfile() {
        navController.navigate(R.id.action_meetPeopleFragment_to_profileDetailsFragment);
    }

    @Override
    public Person onLike() {
        Person person = peopleToMeet.get(personIndex);
        Log.d(TAG, "onLike: person " + person.getName() + " likes you:  " + person.likesUser());
        if(peopleToMeet.get(personIndex).likesUser()){
            Match newMatch = new Match(peopleToMeet.get(personIndex), new Date());
            ArrayList<Match> newMatchList = mainUser.getMatches();
            newMatchList.add(newMatch);
            Log.d(TAG, "onLike: new match " + newMatch);
        }
        personIndex++;
        return peopleToMeet.get(personIndex);
    }

    @Override
    public Person onDeny() {
        personIndex++;
        Log.d(TAG, "onDeny: " + (personIndex < peopleToMeet.size()));
        if (personIndex < peopleToMeet.size()){
            return peopleToMeet.get(personIndex);
        }else {
            return null;
        }
    }

    public Person getUserToView() {
        if (personIndex < peopleToMeet.size()){
            return peopleToMeet.get(personIndex);
        }else {
            return null;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Match item) {

        Log.d(TAG,"inListFragmentInteraction: Matches" + item);
    }

    @Override
    public void onConversationListItemInteraction(Conversation item) {
        Log.d(TAG, "onConversationListItemInteraction: Conversation " + item);
        Bundle bundle = MessagingFragment.createArgumentBundle(item);
        navController.navigate(R.id.action_messagingMatchesFragment_to_conversationFragment, bundle);
    }
}
