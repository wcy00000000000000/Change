package com.wcy.change.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.wcy.change.R;
import com.wcy.change.dao.RankDao;
import com.wcy.change.dao.UserGoalDao;
import com.wcy.change.dao.daoImpl.RankDaoImpl;
import com.wcy.change.dao.daoImpl.UserGoalDaoImpl;
import com.wcy.change.pojo.UserGoal;
import com.wcy.change.util.MissionItem;
import com.wcy.change.util.MissionItemRecyclerViewAdapter;
import com.wcy.change.util.ProcessGoalList;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {
    private Spinner spinner;
    private TextView missionType;
    private RecyclerView recyclerView;
    private TextView missionNum;       //今日任务数
    private  static TextView missionCompleted;  //今日已完成
    private TextView missionSerials;  //连续打卡时间
    private TextView missionRank;   //排名
    UserGoalDao userGoalImpl = new UserGoalDaoImpl();
    RankDao rankDaoImpl = new RankDaoImpl();
    SharedPreferences sharedPreference;
    String userId;
    List<UserGoal> totalList=new ArrayList<>();
    List<UserGoal> weekList=new ArrayList<>();
    List<UserGoal> todayList=new ArrayList<>();
    List<UserGoal> overdueList=new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        spinner = view.findViewById(R.id.filter);
        //今日任务，一周任务，或者所有任务
        missionType = view.findViewById(R.id.missionType);
        recyclerView = view.findViewById(R.id.mission_item_list);
        missionNum = view.findViewById(R.id.missionNum);
        missionCompleted = view.findViewById(R.id.missionCompleted);
        missionSerials=view.findViewById(R.id.missionSerials);
        missionRank = view.findViewById(R.id.missionRank);
        sharedPreference = getContext().getSharedPreferences("change", MODE_PRIVATE);
        userId = sharedPreference.getString("userID",null);
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
        final String[] type = new String[]{"今日任务", "一周任务", "所有任务"};
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                missionType.setText(type[position]);
                totalList=userGoalImpl.findAllGoal(userId);
                ProcessGoalList.distinguish(totalList);
                weekList=ProcessGoalList.getWeekGoalList();
                todayList=ProcessGoalList.getTodayGoalList();
                switch (position) {
                    case 0:
                        initMissionList(todayList);
                        missionNum.setText(String.valueOf(todayList.size()));
                        break;
                    case 1:
                        initMissionList(weekList);
                        missionNum.setText(String.valueOf(weekList.size()));
                        break;
                    case 2:
                        initMissionList(totalList);
                        missionNum.setText(String.valueOf(totalList.size()));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(0);
            }
        });

        totalList=userGoalImpl.findAllGoal(userId);
        ProcessGoalList.distinguish(totalList);
        weekList=ProcessGoalList.getWeekGoalList();
        todayList=ProcessGoalList.getTodayGoalList();

        initMissionList(todayList);
        initPart();

    }


    //给recyclerView绑定数据
    public void initMissionList(List<UserGoal> goals){
//        if (userId!=null){
//            List<UserGoal> goals = userGoalImpl.findAllGoal(userId);
            List<MissionItem> list = new ArrayList<>();
            for (int i = 0,len =goals.size(); i <len; i++) {
                MissionItem item = new MissionItem();
                UserGoal goal = goals.get(i);

                item.setCheckedToday(ProcessGoalList.isCheckedToday(goal));
                item.setId(goal.getGoalid());
                item.setDay(goal.getClockin());
                item.setName("任务:"+goal.getName());
                list.add(item);
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(new MissionItemRecyclerViewAdapter(list, getContext()));
  //      }

    }

    //初始化上半部分的值
    public void initPart(){
        missionSerials.setText(String.valueOf(rankDaoImpl.getCount(userId)));
        missionRank.setText(String.valueOf(rankDaoImpl.getCurrRank(userId)));
        missionNum.setText(String.valueOf(todayList.size()));
        int todayFinsh=ProcessGoalList.isFinishedToday(totalList);
        missionCompleted.setText(String.valueOf(todayFinsh));
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString("todayFinish", String.valueOf(todayFinsh));
        editor.apply();

    }

    public static TextView getMissionCompleted(){
        return missionCompleted;
    }
}
