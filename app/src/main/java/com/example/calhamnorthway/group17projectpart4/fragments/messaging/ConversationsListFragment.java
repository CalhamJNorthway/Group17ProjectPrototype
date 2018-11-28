package com.example.calhamnorthway.group17projectpart4.fragments.messaging;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Conversation;
import com.example.calhamnorthway.group17projectpart4.data.User;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnConversationListFragmentInteractionListener}
 * interface.
 */
public class ConversationsListFragment extends Fragment {

    private OnConversationListFragmentInteractionListener listener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ConversationsListFragment() {
    }

    @SuppressWarnings("unused")
    public static ConversationsListFragment newInstance() {
        return new ConversationsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_converations_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            ArrayList<Conversation> conversations = listener.getMainUser().getConversations();
            final RecyclerView.Adapter adapter = new ConversationsAdapter(conversations, listener);
            recyclerView.setAdapter(adapter);

            listener.setOnConversationRemovalListener(new OnConversationRemovedListener() {
                @Override
                public void onConversationRemoved(int position) {
                    adapter.notifyItemRemoved(position);
                }
            });
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnConversationListFragmentInteractionListener) {
            listener = (OnConversationListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnConversationListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener.setOnConversationRemovalListener(null);
        listener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnConversationListFragmentInteractionListener {
        void onConversationListItemInteraction(Conversation item);
        void setOnConversationRemovalListener(OnConversationRemovedListener listener);
        User getMainUser();
    }

    public interface OnConversationRemovedListener {
        void onConversationRemoved(int position);
    }
}
