package com.example.calhamnorthway.group17projectpart4.fragments.profileDetails;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.calhamnorthway.group17projectpart4.MainActivity;
import com.example.calhamnorthway.group17projectpart4.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment {

    private static final String TAG = "ImageFragment";

    public static final int SMALL_VIEW = 0;
    public static final int FULL_VIEW = 1;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int imageId;
    private int viewSize;

    private OnFragmentInteractionListener mListener;

    public ImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param imageId Parameter 1.
     * @param viewSize Parameter 2.
     * @return A new instance of fragment ImageFragment.
     */
    public static ImageFragment newInstance(int imageId, int viewSize) {
        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(createArgumentBundle(imageId, viewSize));
        return fragment;
    }

    public static Bundle createArgumentBundle(int imageId, int viewSize) {
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, imageId);
        args.putInt(ARG_PARAM2, viewSize);
        return args;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageId = getArguments().getInt(ARG_PARAM1);
            viewSize = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_image, container, false);
        ImageView imageView = v.findViewById(R.id.profileImage);
        imageView.setImageResource(imageId);

        ImageButton button = v.findViewById(R.id.back);

        if(viewSize == FULL_VIEW) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonPressed();
                }
            });
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            button.setVisibility(View.GONE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonPressed();
                }
            });
        }

        return v;
    }

    public void onButtonPressed() {
        if (mListener != null) {
            if(viewSize == FULL_VIEW) {
                mListener.onBack();
            } else {
                mListener.onEnlarge(imageId);
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(viewSize == FULL_VIEW) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showActionBar(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(viewSize == FULL_VIEW) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showActionBar(true);
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
        void onBack();
        void onEnlarge(int imageId);
    }
}
