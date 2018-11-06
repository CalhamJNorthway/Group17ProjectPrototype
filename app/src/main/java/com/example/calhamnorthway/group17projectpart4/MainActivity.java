package com.example.calhamnorthway.group17projectpart4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate User Array for app
        ArrayList<UserVO> allUsers = new ArrayList<>();

        //Create user
        UserVO calham = new UserVO("Calham Northway", 21, Gender.Male, "Sexxxier than the Dos Equis guy.", null, null);

        //Add user to arrayList
        allUsers.add(calham);


    }
}
