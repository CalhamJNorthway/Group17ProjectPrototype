package com.example.calhamnorthway.group17projectpart4.data;

import java.util.Date;

public class Match {
    private UserVO user;
    private Date dateMatched;

    public Match(UserVO user, Date dateMatched) {
        this.user = user;
        this.dateMatched = dateMatched;
    }

    public UserVO getUser() {
        return user;
    }

    public Date getDateMatched() {
        return dateMatched;
    }
}
