package com.wcy.change.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wcy.change.R;

public class MissionItemViewHolder extends RecyclerView.ViewHolder {
    private TextView name, day;
    private ImageView check;
    private TextView checkView; //点击此位置，会显示打卡对勾

    public MissionItemViewHolder(@NonNull View view) {
        super(view);
        name = view.findViewById(R.id.item_name);
        day = view.findViewById(R.id.item_day);
        check = view.findViewById(R.id.item_check);
        check.setVisibility(View.GONE);
        checkView = view.findViewById(R.id.item_check_text);

    }

    public ImageView getCheck(){
        return check;
    }
    public TextView getCheckView(){
        return checkView;
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
