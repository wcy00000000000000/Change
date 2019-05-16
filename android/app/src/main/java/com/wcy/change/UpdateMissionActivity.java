package com.wcy.change;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.wcy.change.dao.UserGoalDao;
import com.wcy.change.dao.daoImpl.UserGoalDaoImpl;
import com.wcy.change.pojo.UserGoal;
import com.wcy.change.util.datepicker.CustomDatePicker;
import com.wcy.change.util.datepicker.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//任务详情
public class UpdateMissionActivity extends AppCompatActivity {
    private TextView mStartDate, mEndDate;
    private CustomDatePicker mStartDatePicker, mEndDatePicker;
    UserGoalDao userGoalDao = new UserGoalDaoImpl();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_edit);
        final Button finish = findViewById(R.id.finish_edit);
        final Button back = findViewById(R.id.mission_back);
        final EditText name = findViewById(R.id.editName);
        final EditText description = findViewById(R.id.editDescription);
        Switch open = findViewById(R.id.editOpen);

        //获取需要更改的任务
        Intent intent = getIntent();
        final String goalId = intent.getStringExtra("goalUpdate");
        final UserGoal goal= userGoalDao.findGoalById(goalId);
        name.setText( goal.getName());
        description.setText(goal.getDescription());
        if (goal.getOpen()==1)
            open.setChecked(true);


        //编辑开始时间
        findViewById(R.id.ll_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartDatePicker.show(mStartDate.getText().toString());
            }
        });
        mStartDate = findViewById(R.id.tv_selected_date);
        initStartDatePicker(goal.getStartDate());
        //截止时间
        findViewById(R.id.s_end_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEndDatePicker.show(mEndDate.getText().toString());
                long beginTimestamp =DateFormatUtils.str2Long(mStartDate.getText().toString(), false);
                Date newEndDate = new Date(beginTimestamp);
                initEndDatePicker(newEndDate);
            }
        });
        mEndDate = findViewById(R.id.endDate);
        initEndDatePicker(goal.getEndDate());

        open.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked)
                    goal.setOpen(1);
                else
                    goal.setOpen(0);
            }
        });
        //完成编辑
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
                Date g_start_date=goal.getStartDate();
                Date g_end_date=goal.getEndDate();
                try {
                    g_start_date = formatter.parse(mStartDate.getText().toString());
                    g_end_date=formatter.parse(mEndDate.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                goal.setName(name.getText().toString());
                goal.setStartDate(g_start_date);
                goal.setEndDate(g_end_date);
                goal.setDescription(description.getText().toString());

                //更新goal
                userGoalDao.update(goal);
                Intent intent = new Intent(UpdateMissionActivity.this,MissionActivity.class);
                intent.putExtra("goalId",goalId);
                startActivity(intent);
            }
        });

        //返回到主页面
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateMissionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initStartDatePicker(Date start) {
        long endTimestamp = DateFormatUtils.str2Long("2100-12-31", false);
        long beginTimestamp = start.getTime();

        mStartDate.setText(DateFormatUtils.long2Str(beginTimestamp, false));

        // 通过时间戳初始化日期，毫秒级别
        mStartDatePicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                mStartDate.setText(DateFormatUtils.long2Str(timestamp, false));
                mEndDate.setText(mStartDate.getText());
            }
        }, beginTimestamp, endTimestamp);
        mStartDatePicker.setCancelable(false);
        mStartDatePicker.setCanShowPreciseTime(false);
        mStartDatePicker.setScrollLoop(false);
        mStartDatePicker.setCanShowAnim(false);
    }

    private void initEndDatePicker(Date end){
        long endTimestamp = DateFormatUtils.str2Long("2100-12-31", false);
        long beginTimestamp =end.getTime();

        mEndDate.setText(DateFormatUtils.long2Str(beginTimestamp, false));

        // 通过时间戳初始化日期，毫秒级别
        mEndDatePicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                mEndDate.setText(DateFormatUtils.long2Str(timestamp, false));
            }
        }, beginTimestamp, endTimestamp);
        mEndDatePicker.setCancelable(false);
        mEndDatePicker.setCanShowPreciseTime(false);
        mEndDatePicker.setScrollLoop(false);
        mEndDatePicker.setCanShowAnim(false);
    }

}

