package com.wcy.change.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wcy.change.R;
import com.wcy.change.util.RankItem;
import com.wcy.change.util.RankItemRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RankFragment extends Fragment {

    private RecyclerView recyclerView;

    public RankFragment() {
        // Required empty public constructor
    }

    public static RankFragment newInstance() {
        RankFragment fragment = new RankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        recyclerView = view.findViewById(R.id.brief_rank_item_list);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onStart() {
        super.onStart();
        List<RankItem> list = new ArrayList<>();
        RankItem item = new RankItem();
        item.setRank("冠军");
        item.setDay(100);
        item.setName("用户1");
        list.add(item);
        item = new RankItem();
        item.setRank("亚军");
        item.setDay(74);
        item.setName("用户2");
        list.add(item);
        item = new RankItem();
        item.setRank("季军");
        item.setDay(55);
        item.setName("用户3");
        list.add(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RankItemRecyclerViewAdapter(list, getContext()));
    }

}
