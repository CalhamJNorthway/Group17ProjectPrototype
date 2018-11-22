package com.example.calhamnorthway.group17projectpart4.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Message implements Parcelable {
    private Person user;
    private Date timestamp;
    private String text;

    public Message(Person user, Date timestamp, String text) {
        this.user = user;
        this.timestamp = timestamp;
        this.text = text;
    }

    public Person getPerson() {
        return user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getText() {
        return text;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeLong(this.timestamp != null ? this.timestamp.getTime() : -1);
        dest.writeString(this.text);
    }

    protected Message(Parcel in) {
        this.user = in.readParcelable(Person.class.getClassLoader());
        long tmpTimestamp = in.readLong();
        this.timestamp = tmpTimestamp == -1 ? null : new Date(tmpTimestamp);
        this.text = in.readString();
    }

    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            return new Message(source);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}
