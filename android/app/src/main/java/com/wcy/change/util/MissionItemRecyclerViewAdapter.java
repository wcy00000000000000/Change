package com.wcy.change.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wcy.change.R;

import java.util.List;

public class MissionItemRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<MissionItem> list;
    private Context context;

    public MissionItemRecyclerViewAdapter(List<MissionItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MissionItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample_mission_item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MissionItemViewHolder missionItemView = (MissionItemViewHolder) viewHolder;
        missionItemView.setDay("第" + list.get(i).getDay() + "天");
        missionItemView.setTitle(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
