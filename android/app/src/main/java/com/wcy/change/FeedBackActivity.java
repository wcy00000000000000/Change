package com.wcy.change;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        final Context context=this;

        final Button back=findViewById(R.id.fb_back);
        final Button submit=findViewById(R.id.fb_submit);
        final EditText text=findViewById(R.id.fb_description);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FeedBackActivity) context).finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description=text.getText().toString();
                if(!description.equals("")){
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("感谢您的反馈，祝您使用愉快！").create().show();
                }
            }
        });
    }

}
