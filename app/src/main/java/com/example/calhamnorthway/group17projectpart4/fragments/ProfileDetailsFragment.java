package com.example.calhamnorthway.group17projectpart4.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.calhamnorthway.group17projectpart4.MainActivity;
import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Person;
import com.example.calhamnorthway.group17projectpart4.data.Profile;
import com.example.calhamnorthway.group17projectpart4.fragments.profileDetails.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ProfileDetailsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private Person potentialMatch;

    public ProfileDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_details, container, false);
        setPerson(((MainActivity)getActivity()).getUserToView());

        ViewPager viewPager = v.findViewById(R.id.profilePicSlider);
        viewPager.setAdapter(new ViewPagerAdapter(getActivity(), potentialMatch.getProfile().getPictureIds()));

        TextView name = v.findViewById(R.id.name);
        name.setText(potentialMatch.getName());

        TextView age = v.findViewById(R.id.age);
        age.setText(potentialMatch.getAge()+"");

        TextView relationShipStatus = v.findViewById(R.id.relationshipStatus);
        relationShipStatus.setText(potentialMatch.getProfile().getRelationshipStatus().toString());

        TextView matchedOn = v.findViewById(R.id.job);
        matchedOn.setText(potentialMatch.getProfile().getJob());

        TextView gender = v.findViewById(R.id.gender);
        gender.setText(potentialMatch.getGender().toString());

        TextView description = v.findViewById(R.id.description);
        description.setText(potentialMatch.getProfile().getDescription());




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
        void onListFragmentInteraction(Person item);
    }

    private void setPerson(Person potentialMatch){
        this.potentialMatch = potentialMatch;
    }
}
