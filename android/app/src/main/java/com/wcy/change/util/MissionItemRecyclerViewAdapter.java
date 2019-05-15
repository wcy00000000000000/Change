package com.wcy.change.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wcy.change.EditMissionActivity;
import com.wcy.change.MainActivity;
import com.wcy.change.MissionActivity;
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

        final MissionItem currentItem = list.get(i);
        missionItemView.setDay("第" + currentItem.getDay() + "天");
        missionItemView.setTitle(currentItem.getName());

        missionItemView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //item点击事件
                Intent intent = new Intent(context,MissionActivity.class);
                intent.putExtra("mission",currentItem.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
