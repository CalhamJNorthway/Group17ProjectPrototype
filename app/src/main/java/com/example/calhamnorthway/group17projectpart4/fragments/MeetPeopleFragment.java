package com.example.calhamnorthway.group17projectpart4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.calhamnorthway.group17projectpart4.MainActivity;
import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Person;
import com.example.calhamnorthway.group17projectpart4.data.Profile;
import com.example.calhamnorthway.group17projectpart4.data.User;

public class MeetPeopleFragment extends Fragment {
    private User loggedInUser;

    private OnFragmentInteractionListener mListener;

    public MeetPeopleFragment() {
        // Required empty public constructor
    }

    public static MeetPeopleFragment newInstance(String param1, String param2) {
        MeetPeopleFragment fragment = new MeetPeopleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_meet_people, container, false);

        setLoggedInUser(((MainActivity)getActivity()).getMainUser());

        final Button likeButton = v.findViewById(R.id.acceptButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mListener.onLike();
            }
        });

        final Button denyButton = v.findViewById(R.id.acceptButton);
        denyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDeny();
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onGoToProfile();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onGoToProfile();
        Person onLike();
        Person onDeny();
    }

    private void setLoggedInUser(User loggedInUser){
        this.loggedInUser = loggedInUser;
    }
}
