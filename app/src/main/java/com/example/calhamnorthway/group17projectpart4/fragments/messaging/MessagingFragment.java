package com.example.calhamnorthway.group17projectpart4.fragments.messaging;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.calhamnorthway.group17projectpart4.MainActivity;
import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Conversation;
import com.example.calhamnorthway.group17projectpart4.data.Message;
import com.example.calhamnorthway.group17projectpart4.data.Person;
import com.example.calhamnorthway.group17projectpart4.data.User;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MessagingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MessagingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessagingFragment extends Fragment {

    private static final String TAG = "MessagingFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private Conversation conversation;

    private EditText messageInput;
    private ImageButton sendButton;

    private MessagingAdapter adapter;
    private RecyclerView recyclerView;


    private OnFragmentInteractionListener listener;

    public MessagingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MessagingFragment.
     */
    public static MessagingFragment newInstance() {
        return new MessagingFragment();
    }

    public static Bundle createArgumentBundle(Conversation conversation) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_PARAM1, conversation);
        return bundle;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            conversation = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_conversation, container, false);
        Context context = v.getContext();
        recyclerView = v.findViewById(R.id.messages);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MessagingAdapter(conversation.getMessages());
        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(adapter.getItemCount()-1);

        ImageView imageView = v.findViewById(R.id.profile_image);
        Glide.with(this)
                .load(conversation.getPerson().getProfile().getPictureIds()[0])
                .into(imageView);



        messageInput = v.findViewById(R.id.inputField);
        sendButton = v.findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSendMessage();
            }
        });

        FloatingActionButton fab = v.findViewById(R.id.profile_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFabPressed();
            }
        });

        return v;
    }

    public void onSendMessage() {
        String newMessageText = messageInput.getText().toString();
        messageInput.setText("");
        Message newMessage = new Message(listener.getMainUser(), new Date(), newMessageText);
        conversation.setLastMessage(newMessage);
        adapter.addNewMessage(newMessage);
        recyclerView.scrollToPosition(adapter.getItemCount()-1);
    }

    public void onFabPressed() {
        if(listener != null) {
            listener.onGoToProfile(conversation.getPerson());
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity activity = (MainActivity) getActivity();
        activity.setToolbar(null);
        if(listener != null) {
            listener.hideKeyboard();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setToolbar(toolbar);

        listener.setTitle(conversation.getPerson().getName());
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
        void onGoToProfile(Person person);
        User getMainUser();
        void hideKeyboard();
        void setTitle(String title);
    }
}
