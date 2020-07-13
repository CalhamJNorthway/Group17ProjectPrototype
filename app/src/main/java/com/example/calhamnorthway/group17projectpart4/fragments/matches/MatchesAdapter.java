package com.example.calhamnorthway.group17projectpart4.fragments.matches;
import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.transition.TransitionManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.calhamnorthway.group17projectpart4.data.Match;
import com.example.calhamnorthway.group17projectpart4.fragments.matches.MatchesListFragment.OnMatchesListFragmentInteractionListener;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.calhamnorthway.group17projectpart4.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Match} and makes a call to the
 * specified {@link OnMatchesListFragmentInteractionListener}.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private static final String TAG = "MatchesAdapter";

    public final List<Match> items;
    private final OnMatchesListFragmentInteractionListener listener;

    private int expandedPosition = -1;

    private RecyclerView recyclerView;

    public MatchesAdapter(List<Match> items, OnMatchesListFragmentInteractionListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MatchesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match,parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.item = items.get(position);
        holder.nameView.setText(holder.item.getPerson().getName());
        holder.d.setText(holder.item.getDateMatched());

        holder.item.getDateMatched();
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
                    listener.onMatchListItemInteraction(holder.item);
                }
            }
        });

        holder.reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onReportUser(holder.item);
                }
            }
        });

        final boolean isExpanded = position == expandedPosition;
        if(!isExpanded) {
            holder.expandItem(false);
        }
        holder.unmatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onUnmatchUser(holder.item);
                    removeItem(holder.item);
                }
            }
        });

        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                holder.expandItem(!isExpanded);
                notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    public void removeItem(Match match) {
        int position = items.indexOf(match);
        items.remove(position);
        if(expandedPosition == position) {
            expandedPosition = -1;
        }
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //layout variables
        public final View view;
        public final ImageView profilePicView;
        public final TextView nameView;
        public final TextView  d;
        public final Button reportButton;
        public final Button unmatchButton;
        //public Date d;
        public Match item;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            profilePicView = view.findViewById(R.id.avatar);
            nameView = view.findViewById(R.id.name);
            d = view.findViewById(R.id.dateMatched);
            reportButton = view.findViewById(R.id.report);
            unmatchButton = view.findViewById(R.id.unmatch);
        }

        public void expandItem(boolean expand) {
            view.setActivated(expand);
            reportButton.setVisibility(expand?View.VISIBLE:View.GONE);
            unmatchButton.setVisibility(expand?View.VISIBLE:View.GONE);
            TransitionManager.beginDelayedTransition(recyclerView);
        }

        @NonNull
        @Override
        public String toString(){
            return super.toString() + " " + nameView.getText() + ": " + d.getText() + "'";
        }



    }
}