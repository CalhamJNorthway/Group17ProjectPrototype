package com.example.calhamnorthway.group17projectpart4.data;

import java.util.Date;

public class Message {
    private User user;
    private Date timestamp;
    private String text;

    public Message(User user, Date timestamp, String text) {
        this.user = user;
        this.timestamp = timestamp;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getText() {
        return text;
    }
}
