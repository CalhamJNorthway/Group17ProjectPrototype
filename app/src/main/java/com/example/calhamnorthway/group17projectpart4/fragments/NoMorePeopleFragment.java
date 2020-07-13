package com.example.calhamnorthway.group17projectpart4.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calhamnorthway.group17projectpart4.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoMorePeopleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoMorePeopleFragment extends Fragment {

    public NoMorePeopleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NoMorePeopleFragment.
     */
    public static NoMorePeopleFragment newInstance() {
        return new NoMorePeopleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_no_more_matches, container, false);
    }

}
