package com.wcy.change;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.wcy.change.dao.UserGoalDao;
import com.wcy.change.dao.daoImpl.UserGoalDaoImpl;
import com.wcy.change.pojo.UserGoal;
import com.wcy.change.util.datepicker.CustomDatePicker;
import com.wcy.change.util.datepicker.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

//任务详情
public class EditMissionActivity extends AppCompatActivity {
    private TextView mStartDate, mEndDate;
    private CustomDatePicker mStartDatePicker, mEndDatePicker;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_edit);
        final Button finish = findViewById(R.id.finish_edit);
        final Button back = findViewById(R.id.mission_back);

        TextView title = findViewById(R.id.mission_title);
        TextView titleAdd = findViewById(R.id.mission_add);
        title.setVisibility(View.GONE);
        final EditText name=findViewById(R.id.editName);
        final EditText description=findViewById(R.id.editDescription);
        final Switch inform=findViewById(R.id.editOpen);
        //编辑开始时间
        findViewById(R.id.ll_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartDatePicker.show(mStartDate.getText().toString());
            }
        });
        mStartDate = findViewById(R.id.tv_selected_date);
        initStartDatePicker();
        //截止时间
        findViewById(R.id.s_end_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEndDatePicker.show(mEndDate.getText().toString());
                initEndDatePicker();
            }
        });
        mEndDate = findViewById(R.id.endDate);
        initEndDatePicker();

        //完成编辑
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
                try {
                    String g_name = name.getText().toString();
                    Date g_start_date = formatter.parse(mStartDate.getText().toString());
                    Date g_end_date=formatter.parse(mEndDate.getText().toString());
                    String g_description=description.getText().toString();

                    SharedPreferences settings=getSharedPreferences("change", MODE_PRIVATE);
                    String uid=settings.getString("userID","");
                    UserGoal userGoal=new UserGoal();
                    userGoal.setUserid(uid);
                    userGoal.setName(g_name);
                    userGoal.setStartDate(g_start_date);
                    userGoal.setEndDate(g_end_date);
                    userGoal.setDescription(g_description);
                    userGoal.setOpen(inform.isChecked()?1:0);

                    final UserGoalDao userGoalDao=new UserGoalDaoImpl();
                    userGoalDao.insertUserGoal(userGoal);

                }catch (Exception e){
                    e.printStackTrace();
                }


                Intent intent = new Intent(EditMissionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //返回到主页面
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditMissionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initStartDatePicker() {
        long endTimestamp = DateFormatUtils.str2Long("2100-12-31", false);
        long beginTimestamp = System.currentTimeMillis();

        mStartDate.setText(DateFormatUtils.long2Str(beginTimestamp, false));

        // 通过时间戳初始化日期，毫秒级别
        mStartDatePicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                mStartDate.setText(DateFormatUtils.long2Str(timestamp, false));
                mEndDate.setText(mStartDate.getText());
            }
        }, beginTimestamp, endTimestamp);
        // 不允许点击屏幕或物理返回键关闭
        mStartDatePicker.setCancelable(false);
        // 不显示时和分
        mStartDatePicker.setCanShowPreciseTime(false);
        // 不允许循环滚动
        mStartDatePicker.setScrollLoop(false);
        // 不允许滚动动画
        mStartDatePicker.setCanShowAnim(false);
    }

    private void initEndDatePicker(){
        long endTimestamp = DateFormatUtils.str2Long("2100-12-31", false);
        long beginTimestamp =DateFormatUtils.str2Long(mStartDate.getText().toString(), false);

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

