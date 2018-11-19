package com.example.calhamnorthway.group17projectpart4.data;

import java.util.ArrayList;

public class Conversation {
    private UserVO user;
    private Message lastMessage;
    private ArrayList<Message> messages;

    public Conversation(UserVO user, Message lastMessage, ArrayList<Message> messages) {
        this.user = user;
        this.lastMessage = lastMessage;
        this.messages = messages;
    }

    public UserVO getUser() {
        return user;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public boolean removeMessage(Message message){
        return messages.remove(message);
    }

    public boolean addMessage(Message message){
        return messages.add(message);
    }
}
