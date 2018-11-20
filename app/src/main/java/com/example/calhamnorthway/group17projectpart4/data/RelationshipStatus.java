package com.example.calhamnorthway.group17projectpart4.data;

public enum RelationshipStatus {
    Single("Single"),
    Relationship("In A Relationship"),
    Complicated("It's Complicated"),
    Engaged("Engaged"),
    Married("Married"),
    Divorced("Divorced"),
    Widowed("Widowed");

    private String text;

    RelationshipStatus(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
