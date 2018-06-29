package com.example.nathie.wochenmarktfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

public class MarketsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MarketsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LinkedList<Wochenmarkt> Markets;

    public MarketsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_markets, container, false);

        DatabaseHelper myDb = new DatabaseHelper(getActivity());
        Markets = (LinkedList<Wochenmarkt>) myDb.getAllWochenmaerkte();
        mRecyclerView = rootView.findViewById(R.id.rv);
        mLayoutManager = new LinearLayoutManager(getActivity());

        for(int i = 0; i < Markets.size(); i++) {
            Wochenmarkt item = Markets.get(i);
            if(Markets.get(i).getFavorite() == 1) {
                Markets.remove(item);
                Markets.addFirst(item);
            }
        }

        mAdapter = new MarketsAdapter(Markets);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}
