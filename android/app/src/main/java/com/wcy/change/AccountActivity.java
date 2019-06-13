package com.wcy.change;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wcy.change.dao.UserDao;
import com.wcy.change.dao.daoImpl.UserDaoImpl;
import com.wcy.change.pojo.User;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        final Context context = this;
        final ImageView iv = findViewById(R.id.launch_account);
        iv.bringToFront();

//        });
        final EditText name = findViewById(R.id.account_name);
        final EditText pwd = findViewById(R.id.account_pwd);
        final EditText pwd1 = findViewById(R.id.account_pwd1);
        final Button confirm = findViewById(R.id.account_confirm);
        final Button edit = findViewById(R.id.account_edit);

        final TextView userid=findViewById(R.id.account_id);
        final Button back=findViewById(R.id.account_back);
        final TextView hint=findViewById(R.id.account_hint);
        final TextView hint1=findViewById(R.id.account_hint1);

        confirm.setVisibility(View.GONE);
        pwd1.setVisibility(View.GONE);

        name.setEnabled(false);
        pwd.setEnabled(false);

        SharedPreferences sharedPreferences=getSharedPreferences("change",MODE_PRIVATE);

        UserDao userDao=new UserDaoImpl();
        User user=userDao.getUser(sharedPreferences.getString("userID",""));
        userid.setText(user.getUserid());
        name.setText(user.getName());
        pwd.setText(user.getPassword());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(AccountActivity.this,MainActivity.class);
//                startActivity(intent);
                ((AccountActivity) context).finish();
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd1.setVisibility(View.VISIBLE);
                edit.setVisibility(View.GONE);
                confirm.setVisibility(View.VISIBLE);

                name.setEnabled(true);
                pwd.setEnabled(true);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_name=name.getText().toString();
                String u_pwd=pwd.getText().toString();
                String u_pwd1=pwd1.getText().toString();

                if(u_name.equals("")||u_pwd.equals("")||u_pwd1.equals("")){
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("请输入用户名/密码").create().show();
                    return;
                }

                if (!u_pwd.equals(u_pwd1)) {
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("密码不一致").create().show();
                }else {

                    edit.setVisibility(View.VISIBLE);
                    pwd1.setVisibility(View.GONE);
                    confirm.setVisibility(View.GONE);

                    name.setEnabled(false);
                    pwd.setEnabled(false);

                    SharedPreferences sharedPreferences=getSharedPreferences("change",MODE_PRIVATE);

                    UserDao userDao=new UserDaoImpl();
                    User user=userDao.getUser(sharedPreferences.getString("userID",""));
                    user.setName(u_name);
                    user.setPassword(u_pwd);

                }
            }
        });



    }

}
