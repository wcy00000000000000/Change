package com.wcy.change;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.wcy.change.dao.UserGoalDao;
import com.wcy.change.dao.daoImpl.UserGoalDaoImpl;
import com.wcy.change.pojo.UserGoal;

import java.text.DateFormat;

public class MissionActivity extends AppCompatActivity {

    private Button edit;
    private Button back;
    private EditText goalName;
    private EditText goalStartTime;
    private EditText goalEndTime;
    private EditText goalCheckNum;
    private TextView goalDescription;
    private TextView goalOpen;
    private Switch open;
    UserGoalDao userGoalDaoImpl = new UserGoalDaoImpl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
        edit = findViewById(R.id.edit_mission);
        back = findViewById(R.id.mission_back);
        goalName=findViewById(R.id.detailName);
        goalStartTime=findViewById(R.id.detailStartTime);
        goalEndTime=findViewById(R.id.detailEndTime);
        goalCheckNum=findViewById(R.id.detailTotal);
        goalDescription=findViewById(R.id.detailDescription);
        goalOpen = findViewById(R.id.detailOpen);

        Intent intent = getIntent();
        final String goalId = intent.getStringExtra("goalId");

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MissionActivity.this,UpdateMissionActivity.class);
                intent.putExtra("goalUpdate",goalId);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MissionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //从主界面选中每个item后展示详情
        initGoalDetail(goalId);

    }

    public void initGoalDetail(String goalId){
        if (goalId!=null){
            UserGoal goal = userGoalDaoImpl.findGoalById(goalId);
            System.out.println(goalId);
            goalName.setText(goal.getName());
            goalStartTime.setText( DateFormat.getDateInstance().format( goal.getStartDate()));
            goalEndTime.setText(DateFormat.getDateInstance().format( goal.getEndDate()));
            goalCheckNum.setText(goal.getClockin().toString());
            goalDescription.setText(goal.getDescription());
            if (goal.getOpen()==1)
                goalOpen.setText("打开");
            else
                goalOpen.setText("关闭");

        }
    }


}
