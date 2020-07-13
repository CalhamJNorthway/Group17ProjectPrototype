package com.example.calhamnorthway.group17projectpart4.data;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.widget.TextView;
import java.text.SimpleDateFormat;


public class Match implements Parcelable {
    private Person user;
    private Date dateMatched;


    public Match(Person user, Date dateMatched) {
        this.user = user;
        this.dateMatched = dateMatched;
    }

    public Person getPerson() {
        return user;
    }

    public String getDateMatched() {
        //formats Date to a String
        SimpleDateFormat formatter=  new SimpleDateFormat("dd.MM.yyyy");//formating date

        return formatter.format(dateMatched);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;

        Match match = (Match) o;

        return user != null ? user.equals(match.user) : match.user == null;
    }

    @NonNull
    @Override
    public String toString() {
        return "Match{" +
                "user=" + user +
                ", dateMatched=" + dateMatched +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeLong(this.dateMatched != null ? this.dateMatched.getTime() : -1);
    }

    @SuppressWarnings("WeakerAccess")
    protected Match(Parcel in) {
        this.user = in.readParcelable(Person.class.getClassLoader());
        long tmpDateMatched = in.readLong();
        this.dateMatched = tmpDateMatched == -1 ? null : new Date(tmpDateMatched);
    }

    public static final Parcelable.Creator<Match> CREATOR = new Parcelable.Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel source) {
            return new Match(source);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };
}
