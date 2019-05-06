package com.wcy.change.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wcy.change.R;

import java.util.List;

public class RankItemRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<RankItem> list;
    private Context context;

    public RankItemRecyclerViewAdapter(List<RankItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RankItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rank_item_view, viewGroup, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RankItemViewHolder rankItemView = (RankItemViewHolder) viewHolder;
        if (list.get(i).getUrl() != null && !list.get(i).getUrl().equals("")) {
            rankItemView.setAvatar(list.get(i).getUrl());
        }
        rankItemView.setName(list.get(i).getName());
        rankItemView.setRank(list.get(i).getRank());
        rankItemView.setDay("打卡" + list.get(i).getDay() + "天");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
