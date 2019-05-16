package com.wcy.change.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wcy.change.EditMissionActivity;
import com.wcy.change.ImageActivity;
import com.wcy.change.MainActivity;
import com.wcy.change.MissionActivity;
import com.wcy.change.R;
import com.wcy.change.dao.UserGoalDao;
import com.wcy.change.dao.daoImpl.UserGoalDaoImpl;
import com.wcy.change.fragments.HomeFragment;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MissionItemRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<MissionItem> list;
    private Context context;
    private UserGoalDao userGoalDao=new UserGoalDaoImpl();

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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final MissionItemViewHolder missionItemView = (MissionItemViewHolder) viewHolder;

        final MissionItem currentItem = list.get(i);
        missionItemView.setDay("第" + currentItem.getDay() + "天");
        missionItemView.setTitle(currentItem.getName());

        if (currentItem.getCheckedToday()){
            missionItemView.getCheck().setVisibility(View.VISIBLE);
        }else if (ProcessGoalList.isTodayGoal(currentItem.getId().toString())){   //非今日任务不能再打卡
            //点击签到
            missionItemView.getCheckView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userGoalDao.checkin(currentItem.getId().toString());
                    missionItemView.getCheck().setVisibility(View.VISIBLE);
                    int day =currentItem.getDay()+1;
                    missionItemView.setDay("第" + day + "天");

                    //更新今日已完成数目
                    SharedPreferences sharedPreference = context.getSharedPreferences("change", MODE_PRIVATE);
                    String todayFinish = sharedPreference.getString("todayFinish","0");
                    int finished = Integer.parseInt(todayFinish)+1;
                    SharedPreferences.Editor editor = sharedPreference.edit();
                    editor.putString("todayFinish", String.valueOf(finished));
                    editor.apply();
                    HomeFragment.getMissionCompleted().setText(String.valueOf(finished));

                    //如果签到数目刚好是15的倍数，则跳转到剧情界面
                    if (day%15==0 && day!=0){
                        Intent intent = new Intent(context,ImageActivity.class);
                        int storyLevel = day/15;
                        intent.putExtra("storyLevel",String.valueOf(storyLevel));
                        context.startActivity(intent);
                    }

                }
            });

        }



        missionItemView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //item点击事件
                Intent intent = new Intent(context,MissionActivity.class);
                intent.putExtra("goalId",currentItem.getId().toString());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
