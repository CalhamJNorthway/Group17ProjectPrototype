package com.example.calhamnorthway.group17projectpart4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

    private ProfileDetailsFragment profileDescription;

    private OnFragmentInteractionListener mListener;

    public MeetPeopleFragment() {
        // Required empty public constructor
    }

    public static MeetPeopleFragment newInstance() {
        return new MeetPeopleFragment();
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

        this.profileDescription = new ProfileDetailsFragment();
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, profileDescription);
        transaction.commit();


        setLoggedInUser(((MainActivity)getActivity()).getMainUser());

        FloatingActionButton likeButton = v.findViewById(R.id.acceptButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person next = mListener.onLike();
                profileDescription.setPerson(next);
            }
        });

        FloatingActionButton denyButton = v.findViewById(R.id.denyButton);
        denyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person next = mListener.onDeny();
                profileDescription.setPerson(next);
            }
        });

        return v;
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
        Person onLike();
        Person onDeny();
    }

    private void setLoggedInUser(User loggedInUser){
        this.loggedInUser = loggedInUser;
    }
}
