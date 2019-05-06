package com.wcy.change.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i<7;i++){
            entries.add(new BarEntry(i,i+1));
        }
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

}
