package com.wcy.change;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wcy.change.dao.UserDao;
import com.wcy.change.dao.daoImpl.UserDaoImpl;
import com.wcy.change.pojo.User;
import com.wcy.change.util.HttpCallbackListener;
import com.wcy.change.util.HttpRequestUtil;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        final Context context = this;
        final ImageView iv = findViewById(R.id.launch1);
        iv.bringToFront();
        Glide.with(this)
                .load(R.drawable.page2)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .apply(RequestOptions.skipMemoryCacheOf(true))
                .apply(RequestOptions.bitmapTransform(new CenterCrop()))
                .into(iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("change", MODE_PRIVATE);
                if (sharedPreferences.contains("userID")) {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                iv.setVisibility(View.GONE);
            }
        });
        final EditText name = findViewById(R.id.name);
        final EditText pwd = findViewById(R.id.pwd);
        final EditText pwd1 = findViewById(R.id.pwd1);
        final Button register = findViewById(R.id.register);
        final Button login = findViewById(R.id.login);
        final TextView hint = findViewById(R.id.hint);
        final TextView hint1 = findViewById(R.id.hint1);
        login.setVisibility(View.GONE);
        hint1.setVisibility(View.GONE);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd1.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                hint.setVisibility(View.GONE);
                login.setVisibility(View.VISIBLE);
                hint1.setVisibility(View.VISIBLE);
            }
        });
        hint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd1.setVisibility(View.VISIBLE);
                register.setVisibility(View.VISIBLE);
                hint.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                hint1.setVisibility(View.GONE);
            }
        });
        final UserDao userDao = new UserDaoImpl();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("") || pwd.getText().toString().equals("")) {
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("请输入用户名/密码").create().show();
                    return;
                }
                final User user = userDao.getUser(name.getText().toString());
                if (user == null || !user.getPassword().equals(pwd.getText().toString())) {
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("用户名/密码错误").create().show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("change", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userID", user.getUserid());
                    editor.apply();
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = userDao.getUser(name.getText().toString());
                if (name.getText().toString().equals("") || pwd.getText().toString().equals("")) {
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("请输入用户名/密码").create().show();
                    return;
                }
                if (!pwd.getText().toString().equals(pwd1.getText().toString())) {
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("两次输入的密码不一致").create().show();
                    return;
                }
                if (user != null) {
                    new AlertDialog.Builder(context).setTitle("提示").setMessage("该用户名已被注册").create().show();
                } else {
                    User u = new User();
                    u.setUserid(name.getText().toString());
                    u.setPassword(pwd.getText().toString());
                    userDao.insertUser(u);
                    SharedPreferences sharedPreferences = getSharedPreferences("change", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userID", u.getUserid());
                    editor.apply();
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
