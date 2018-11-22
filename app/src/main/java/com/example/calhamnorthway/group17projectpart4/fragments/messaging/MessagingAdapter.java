package com.example.calhamnorthway.group17projectpart4.fragments.messaging;

import android.support.annotation.NonNull;
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
import com.example.calhamnorthway.group17projectpart4.data.Message;
import com.example.calhamnorthway.group17projectpart4.data.User;

import java.util.List;

public class MessagingAdapter extends RecyclerView.Adapter<MessagingAdapter.ViewHolder> {

    private final List<Message> items;

    public MessagingAdapter(List<Message> items) {
        this.items = items;
    }

    @Override
    public MessagingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == 0) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_other, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_user, parent, false);
        }
        return new MessagingAdapter.ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        Message message = items.get(position);
        return message.getPerson() instanceof User? 1 : 0;
    }

    @Override
    public void onBindViewHolder(final MessagingAdapter.ViewHolder holder, int position) {
        holder.item = items.get(position);
        holder.messageView.setText(holder.item.getText());

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        Glide.with(holder.view)
                .load(holder.item.getPerson().getProfile().getPictureIds()[0])
                .apply(options)
                .into(holder.profilePicView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addNewMessage(Message newMessage) {
        items.add(newMessage);
        notifyItemInserted(items.size()-1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final ImageView profilePicView;
        public final TextView messageView;
        public Message item;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            profilePicView = view.findViewById(R.id.avatar);
            messageView = view.findViewById(R.id.message);
        }

        @Override
        public String toString() {
            return super.toString() + " '" +messageView.getText() + "'";
        }
    }
}
