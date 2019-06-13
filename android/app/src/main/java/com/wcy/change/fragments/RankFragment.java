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
import com.wcy.change.dao.RankDao;
import com.wcy.change.dao.daoImpl.RankDaoImpl;
import com.wcy.change.pojo.Rank;
import com.wcy.change.util.RankItem;
import com.wcy.change.util.RankItemRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Iterator;
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
        RankDao rankDao=new RankDaoImpl();
        List<Rank> ranks=rankDao.getRank();
        List<RankItem> list = new ArrayList<>();
//        for(Rank rank:ranks){
//            RankItem item = new RankItem();
//            item.setRank("冠军");
//            item.setDay(rank.getCount());
//            item.setName(rank.getName());
//            list.add(item);
//        }
//        Iterator it=ranks.iterator();
        RankItem item = new RankItem();
        item.setRank("冠军");
        item.setDay(ranks.get(0).getCount());
        item.setName(ranks.get(0).getName());
        list.add(item);
        item = new RankItem();
        item.setRank("亚军");

        item.setDay(ranks.get(1).getCount());
        item.setName(ranks.get(1).getName());
        list.add(item);
        item = new RankItem();
        item.setRank("季军");
        item.setDay(ranks.get(2).getCount());
        item.setName(ranks.get(2).getName());
        list.add(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RankItemRecyclerViewAdapter(list, getContext()));
    }

}
