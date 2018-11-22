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

import com.example.calhamnorthway.group17projectpart4.MainActivity;
import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Person;
import com.example.calhamnorthway.group17projectpart4.data.User;

public class MeetPeopleFragment extends Fragment {

    private ProfileDetailsFragment profileDescription;

    private OnFragmentInteractionListener mListener;
    private FloatingActionButton likeButton;
    private FloatingActionButton denyButton;

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

        likeButton = v.findViewById(R.id.acceptButton);
        denyButton = v.findViewById(R.id.denyButton);

        if(((MainActivity)getActivity()).getUserToView() != null) {
            this.profileDescription = new ProfileDetailsFragment();
            FragmentManager fm = getChildFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, profileDescription);
            transaction.commit();

            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Person next = mListener.onLike();
                    setNextPersonOrNoMorePeopleWarning(next);
                }
            });

            denyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Person next = mListener.onDeny();
                    setNextPersonOrNoMorePeopleWarning(next);
                }
            });
        } else {
            showNoMorePeopleWarning();
        }

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

    private void setNextPersonOrNoMorePeopleWarning(Person next) {
        if(next != null) {
            profileDescription.setPerson(next);
        } else {
            showNoMorePeopleWarning();
        }
    }

    private void showNoMorePeopleWarning(){
        likeButton.setEnabled(false);
        likeButton.setImageResource(R.drawable.ic_check_grey_300_24dp);
        denyButton.setEnabled(false);
        denyButton.setImageResource(R.drawable.ic_close_grey_300_24dp);

        Fragment fragment = NoMorePeopleFragment.newInstance();
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
    }
}
