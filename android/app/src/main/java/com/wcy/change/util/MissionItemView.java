package com.wcy.change.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wcy.change.R;

public class MissionItemView extends LinearLayout {
    private TextView name, day;
    private ImageView check;

    public MissionItemView(Context context) {
        super(context);
        init(context);
    }

    public MissionItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MissionItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mission_item_view, this);
        name = view.findViewById(R.id.item_name);
        day = view.findViewById(R.id.item_day);
        check = view.findViewById(R.id.item_check);
        check.setVisibility(GONE);
    }

    public void setCheck(String imageUrl) {
        check.setVisibility(VISIBLE);
    }

    public void setTitle(String title) {
        this.name.setText(title);
    }

    public String getTitle() {
        return this.name.getText().toString();
    }

    public void setDay(String day) {
        this.day.setText(day);
    }

    public String getDay() {
        return this.day.getText().toString();
    }
}
