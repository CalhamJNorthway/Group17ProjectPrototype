package com.example.calhamnorthway.group17projectpart4.data;

import java.util.Date;

public class Match {
    private Person user;
    private Date dateMatched;

    public Match(Person user, Date dateMatched) {
        this.user = user;
        this.dateMatched = dateMatched;
    }

    public Person getPerson() {
        return user;
    }

    public Date getDateMatched() {
        return dateMatched;
    }
}
