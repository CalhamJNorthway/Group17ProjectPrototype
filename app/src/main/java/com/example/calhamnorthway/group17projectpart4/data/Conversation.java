package com.example.calhamnorthway.group17projectpart4.data;

import java.util.ArrayList;
import java.util.Collections;

public class Conversation {
    private Person user;
    private Message lastMessage;
    private ArrayList<Message> messages;

    public Conversation(Person user, Message lastMessage, ArrayList<Message> messages) {
        this.user = user;
        this.lastMessage = lastMessage;
        this.messages = messages;
    }

    public Conversation(Person  user, Message... messages){
        this.user = user;
        this.lastMessage = messages[messages.length - 1];
        this.messages = new ArrayList<>();
        Collections.addAll(this.messages, messages);
    }

    public Person getPerson() {
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
