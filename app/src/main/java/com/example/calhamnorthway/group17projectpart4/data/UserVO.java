package com.example.calhamnorthway.group17projectpart4.data;

public class UserVO {
    private String name;
    private Integer age;
    private Enum<Gender> gender;
    private String description;
    private UserVO[] matches;
    private UserVO[] likedPeople;

    public UserVO(String name, Integer age, Enum<Gender> gender, String description, UserVO[] matches, UserVO[] likedPeople){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this. description = description;
        this.matches = matches;
        this.likedPeople = likedPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserVO[] getMatches() {
        return matches;
    }

    public void setMatches(UserVO[] matches) {
        this.matches = matches;
    }

    public UserVO[] getLikedPeople() {
        return likedPeople;
    }

    public void setLikedPeople(UserVO[] likedPeople) {
        this.likedPeople = likedPeople;
    }
}
