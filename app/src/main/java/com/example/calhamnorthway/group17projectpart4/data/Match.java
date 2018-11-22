package com.example.calhamnorthway.group17projectpart4.data;

import java.util.Date;
import android.widget.TextView;
import java.text.SimpleDateFormat;
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

    public String getDateMatched() {
        //formats Date to a String
        SimpleDateFormat formatter=  new SimpleDateFormat("dd.MM.yyyy");//formating date
        String date = formatter.format(dateMatched);

        return date;
    }

    @Override
    public String toString() {
        return "Match{" +
                "user=" + user +
                ", dateMatched=" + dateMatched +
                '}';
    }
}
