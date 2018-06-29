package com.example.nathie.wochenmarktfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.LinkedList;

import static com.example.nathie.wochenmarktfinder.HomeFragment.myDb;

public class MarketsAdapter extends RecyclerView.Adapter<MarketsAdapter.RecyclerViewHolder> {
    private LinkedList<Wochenmarkt> marketList;

    public MarketsAdapter(LinkedList<Wochenmarkt> marketList) {
        this.marketList = marketList;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView type;
        public TextView city;
        public TextView address;
        public TextView opened;
        public TextView contact;
        public TextView offering;
        public ImageButton favorite;
        protected CardView mCardView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            city = itemView.findViewById(R.id.city);
            address = itemView.findViewById(R.id.address);
            opened = itemView.findViewById(R.id.opened);
            contact = itemView.findViewById(R.id.contact);
            offering = itemView.findViewById(R.id.offering);
            favorite = itemView.findViewById(R.id.favorite);
            mCardView = itemView.findViewById(R.id.cardView);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_market, parent, false);
        RecyclerViewHolder view_holder = new RecyclerViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {

        holder.type.setText(marketList.get(position).getType());
        holder.city.setText(marketList.get(position).getCity());
        holder.address.setText(marketList.get(position).getAddress());
        holder.opened.setText(marketList.get(position).getBusiness_time());
        holder.contact.setText(marketList.get(position).getContact());
        holder.offering.setText(marketList.get(position).getOffer());

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (marketList.get(position).getFavorite() == 0) {
                    marketList.get(position).setFavorite(1);
                    holder.favorite.setImageResource(R.drawable.ic_favorite);
                    myDb.Set_Favorite_1(marketList.get(position).get_id());
                }
                else if (marketList.get(position).getFavorite() == 1) {
                    marketList.get(position).setFavorite(0);
                    holder.favorite.setImageResource(R.drawable.ic_favorite_border);
                    myDb.Set_Favorite_0(marketList.get(position).get_id());
                }
            }
        });

        if (marketList.get(position).getFavorite() == 0) {
            holder.favorite.setImageResource(R.drawable.ic_favorite_border);
        } else if (marketList.get(position).getFavorite() == 1) {
            holder.favorite.setImageResource(R.drawable.ic_favorite);
        }
    }

    @Override
    public int getItemCount() {

        return marketList.size();
    }
}