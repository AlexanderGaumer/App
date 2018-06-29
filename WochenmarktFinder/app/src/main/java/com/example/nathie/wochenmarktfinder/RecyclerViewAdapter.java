package com.example.nathie.wochenmarktfinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private ArrayList<RecyclerItem> mRecyclerList;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public RelativeLayout viewForeground, viewBackground;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView);
            viewBackground = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
        }
    }

    public RecyclerViewAdapter(ArrayList<RecyclerItem> recyclerList) {
        mRecyclerList = recyclerList;
    }

    public void setmRecyclerList(ArrayList<RecyclerItem> mRecyclerList) {
        this.mRecyclerList = mRecyclerList;
    }

    public void removeItem(int position) {
        mRecyclerList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(RecyclerItem item, int position) {
        mRecyclerList.add(position, item);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        RecyclerViewHolder view_holder = new RecyclerViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        RecyclerItem currentItem = mRecyclerList.get(position);

        holder.mTextView1.setText(currentItem.getText1());
    }

    @Override
    public int getItemCount() {

        return mRecyclerList.size();
    }
}