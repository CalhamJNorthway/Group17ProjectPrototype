package com.example.calhamnorthway.group17projectpart4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.calhamnorthway.group17projectpart4.MainActivity;
import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Match;
import com.example.calhamnorthway.group17projectpart4.data.Person;
import com.example.calhamnorthway.group17projectpart4.fragments.profileDetails.ImagePagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ProfileDetailsFragment extends Fragment {

    private static final String KEY_MATCH = "Match";

    private OnFragmentInteractionListener mListener;
    private Person person;
    private Match match;
    private FloatingActionButton messagePerson;
    private ViewPager viewPager;
    private TextView name;
    private TextView age;
    private TextView relationShipStatus;
    private TextView jobTitle;
    private TextView gender;
    private TextView description;

    public ProfileDetailsFragment() {
        // Required empty public constructor
    }

    public static Bundle createArgumentBundle(Match match) {
        Bundle args = new Bundle();
        args.putParcelable(KEY_MATCH, match);
        return args;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            match = getArguments().getParcelable(KEY_MATCH);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        if(match != null) {
            v = inflater.inflate(R.layout.fragment_match_profile_details, container, false);
            person = match.getPerson();
            messagePerson = v.findViewById(R.id.message_person);
            messagePerson.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    messagePerson();
                }
            });
        } else {
            v = inflater.inflate(R.layout.fragment_profile_details, container, false);
        }

        this.viewPager = v.findViewById(R.id.profilePicSlider);
        this.name = v.findViewById(R.id.name);
        this.age = v.findViewById(R.id.age);
        this.relationShipStatus = v.findViewById(R.id.relationshipStatus);
        this.jobTitle = v.findViewById(R.id.job);
        this.gender = v.findViewById(R.id.gender);
        this.description = v.findViewById(R.id.description);

        if(person != null) {
            populateViews();
        } else {
            setPerson(((MainActivity) getActivity()).getUserToView());
        }
        return v;
    }

    private void messagePerson() {
        if(mListener != null) {
            mListener.onMessagePerson(person);
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
        void onMessagePerson(Person person);
    }

    public void setPerson(Person person) {
        this.person = person;
        populateViews();
    }

    private void populateViews() {
        this.viewPager.setAdapter(new ImagePagerAdapter(getChildFragmentManager(), person.getProfile().getPictureIds()));
        this.name.setText(person.getName());
        this.age.setText(person.getAge()+"");
        this.relationShipStatus.setText(person.getProfile().getRelationshipStatus().toString());
        this.jobTitle.setText(person.getProfile().getJob());
        this.gender.setText(person.getGender().toString());
        this.description.setText(person.getProfile().getDescription());
    }
}
