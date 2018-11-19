package com.example.calhamnorthway.group17projectpart4.data;

import java.util.ArrayList;

public class User {
    private Profile profile;
    private ArrayList<Match> matches;
    private ArrayList<Conversation> conversations;

    public User(){

    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public ArrayList<Conversation> getConversations() {
        return conversations;
    }

    public Profile getProfile() {
        return profile;
    }

//    public final static ArrayList<User> dummyItems = new ArrayList<>();
//
//    static {
//        dummyItems.add(new User());
//    }
}
