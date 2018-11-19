package com.example.calhamnorthway.group17projectpart4.data;

import java.util.ArrayList;

public class User extends Person {
    private ArrayList<Match> matches;
    private ArrayList<Conversation> conversations;

    public User(String name, int age, Gender gender, Profile profile) {
        super(name, age, gender, profile);
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public ArrayList<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(ArrayList<Conversation> conversations) {
        this.conversations = conversations;
    }
}
