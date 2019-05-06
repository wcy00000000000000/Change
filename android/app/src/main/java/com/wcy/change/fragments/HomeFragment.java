package com.wcy.change.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.wcy.change.R;
import com.wcy.change.util.MissionItem;
import com.wcy.change.util.MissionItemRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private Spinner spinner;
    private TextView missionType;
    private RecyclerView recyclerView;

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
        missionType = view.findViewById(R.id.missionType);
        recyclerView = view.findViewById(R.id.mission_item_list);
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
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(0);
            }
        });
        List<MissionItem> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            MissionItem item = new MissionItem();
            item.setDay(i);
            item.setName("任务" + i);
            list.add(item);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new MissionItemRecyclerViewAdapter(list, getContext()));
    }
}
