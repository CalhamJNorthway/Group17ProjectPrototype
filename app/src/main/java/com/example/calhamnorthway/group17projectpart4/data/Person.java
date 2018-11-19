package com.example.calhamnorthway.group17projectpart4.data;

public class Person {
    private String name;
    private int age;
    private Gender gender;
    private Profile profile;
    private boolean likesUser;

    public Person(String name, int age, Gender gender, Profile profile, boolean likesUser) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.profile = profile;
        this.likesUser = likesUser;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Profile getProfile() {
        return profile;
    }

    public boolean isLikesUser() {
        return likesUser;
    }
}
