package com.example.calhamnorthway.group17projectpart4.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;

public class Conversation implements Parcelable {
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

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.lastMessage, flags);
        dest.writeTypedList(this.messages);
    }

    protected Conversation(Parcel in) {
        this.user = in.readParcelable(Person.class.getClassLoader());
        this.lastMessage = in.readParcelable(Message.class.getClassLoader());
        this.messages = in.createTypedArrayList(Message.CREATOR);
    }

    public static final Parcelable.Creator<Conversation> CREATOR = new Parcelable.Creator<Conversation>() {
        @Override
        public Conversation createFromParcel(Parcel source) {
            return new Conversation(source);
        }

        @Override
        public Conversation[] newArray(int size) {
            return new Conversation[size];
        }
    };
}
