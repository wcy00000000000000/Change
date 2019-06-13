package com.wcy.change.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.wcy.change.R;
import com.wcy.change.dao.RankDao;
import com.wcy.change.dao.UserWeeklyDao;
import com.wcy.change.dao.daoImpl.RankDaoImpl;
import com.wcy.change.dao.daoImpl.UserWeeklyDaoImpl;
import com.wcy.change.pojo.Rank;
import com.wcy.change.pojo.UserWeekly;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RecordFragment extends Fragment {
    public RecordFragment() {
        // Required empty public constructor
    }

    public static RecordFragment newInstance() {
        RecordFragment fragment = new RecordFragment();
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
        View view = inflater.inflate(R.layout.fragment_record, container, false);
        List<BarEntry> entries = new ArrayList<>();

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("change",MODE_PRIVATE);
        String userid=sharedPreferences.getString("userID","");
        UserWeeklyDao userWeeklyDao=new UserWeeklyDaoImpl();
        UserWeekly userWeekly=userWeeklyDao.getUserWeek(userid);
//        for (int i = 0; i<7;i++){
        entries.add(new BarEntry(0,userWeekly.getSun()));
        entries.add(new BarEntry(1,userWeekly.getMon()));
        entries.add(new BarEntry(2,userWeekly.getTue()));
        entries.add(new BarEntry(3,userWeekly.getWed()));
        entries.add(new BarEntry(4,userWeekly.getThur()));
        entries.add(new BarEntry(5,userWeekly.getFri()));
        entries.add(new BarEntry(6,userWeekly.getSat()));

        final String[] labels = {"周日","周一","周二","周三","周四","周五","周六"};
        BarDataSet barDataSet= new BarDataSet(entries,"");
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        BarChart barChart = view.findViewById(R.id.barChart);
        barChart.setData(new BarData(barDataSet));
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getLegend().setEnabled(false);
        barChart.getXAxis().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return labels[(int) value];
            }
        });
        barChart.getAxisLeft().setDrawZeroLine(true);
        barChart.getAxisLeft().setDrawLabels(false);
        barChart.getAxisLeft().setDrawAxisLine(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        Description description = new Description();
        description.setText("");
        barChart.setDescription(description);



//        Object temp=getView();
//        TextView count=getView().findViewById(R.id.missionNumSeries);
//        TextView sumit=getView().findViewById(R.id.missionMax);
//        TextView average=getView().findViewById(R.id.missionAverage);
//        TextView todayCheck=getView().findViewById(R.id.today_check);
//
//        RankDao rankDao=new RankDaoImpl();
//        Rank rank=rankDao.getAllDays(userid);
//        count.setText(rank.getCount());
//
//        int[] days={userWeekly.getSun(),userWeekly.getMon(),userWeekly.getTue(),userWeekly.getWed(),userWeekly.getThur(),userWeekly.getFri(),userWeekly.getSat()};
//        int sum=0;
//        int max=0;
//        for(int i=0;i<7;i++){
//            max=max>days[i]?max:days[i];
//            sum+=days[i];
//
//        }
//        int ave=sum/7;
//        sumit.setText(max);
//        average.setText(ave);
//
//        String todayTimes=sharedPreferences.getString("todayFinish","");
//        todayCheck.setText(todayTimes);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("change",MODE_PRIVATE);
        String userid=sharedPreferences.getString("userID","");
        UserWeeklyDao userWeeklyDao=new UserWeeklyDaoImpl();
        UserWeekly userWeekly=userWeeklyDao.getUserWeek(userid);

        TextView count=getView().findViewById(R.id.missionNumSeries);
        TextView sumit=getView().findViewById(R.id.missionMax);
        TextView average=getView().findViewById(R.id.missionAverage);
        TextView todayCheck=getView().findViewById(R.id.today_check);

        RankDao rankDao=new RankDaoImpl();
        Rank rank=rankDao.getAllDays(userid);
        count.setText(String.valueOf(rank.getCount()));

        int[] days={userWeekly.getSun(),userWeekly.getMon(),userWeekly.getTue(),userWeekly.getWed(),userWeekly.getThur(),userWeekly.getFri(),userWeekly.getSat()};
        int sum=0;
        int max=0;
        for(int i=0;i<7;i++){
            max=max>days[i]?max:days[i];
            sum+=days[i];

        }
        int ave=sum/7;
        sumit.setText(String.valueOf(max));
        average.setText(String.valueOf(ave));

        String todayTimes=sharedPreferences.getString("todayFinish","");
        todayCheck.setText(String.valueOf(todayTimes));

    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

}
