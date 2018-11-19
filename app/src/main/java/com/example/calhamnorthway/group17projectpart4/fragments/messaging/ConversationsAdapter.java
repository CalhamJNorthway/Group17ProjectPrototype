package com.example.calhamnorthway.group17projectpart4.fragments.messaging;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.calhamnorthway.group17projectpart4.R;
import com.example.calhamnorthway.group17projectpart4.data.Conversation;
import com.example.calhamnorthway.group17projectpart4.fragments.messaging.ConversationsListFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Conversation} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class ConversationsAdapter extends RecyclerView.Adapter<ConversationsAdapter.ViewHolder> {

    private final List<Conversation> items;
    private final OnListFragmentInteractionListener listener;

    public ConversationsAdapter(List<Conversation> items, OnListFragmentInteractionListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_converation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = items.get(position);
        holder.nameView.setText(holder.item.getPerson().getName());
        holder.messageView.setText(holder.item.getLastMessage().getText());

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        Glide.with(holder.view)
                .load(holder.item.getPerson().getProfile().getPictureIds()[0])
                .apply(options)
                .into(holder.profilePicView);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onListFragmentInteraction(holder.item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final ImageView profilePicView;
        public final TextView nameView;
        public final TextView messageView;
        public Conversation item;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            profilePicView = view.findViewById(R.id.avatar);
            nameView = view.findViewById(R.id.name);
            messageView = view.findViewById(R.id.last_message);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nameView.getText() +": " +messageView.getText() + "'";
        }
    }
}
