package com.example.calhamnorthway.group17projectpart4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Person;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportUserDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportUserDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportUserDialogFragment extends AppCompatDialogFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private Person person;

    private OnFragmentInteractionListener listener;

    public ReportUserDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MatchedDialogFragment.
     */
    public static ReportUserDialogFragment newInstance(Person person) {
        ReportUserDialogFragment fragment = new ReportUserDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, person);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            person = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.inappropriate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReportedButtonClick();
                dismiss();
            }
        });

        button = view.findViewById(R.id.other);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReportedButtonClick();
                dismiss();
            }
        });

        button = view.findViewById(R.id.cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public void onReportedButtonClick() {
        if (listener != null) {
            listener.onReported(person);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
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
        void onReported(Person person);
    }
}
