package com.wcy.change.dao.daoImpl;

import android.os.AsyncTask;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.wcy.change.dao.UserDao;
import com.wcy.change.pojo.User;
import com.wcy.change.util.HttpCallbackListener;
import com.wcy.change.util.HttpRequestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by WCY on 2019/4/13
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(String userId) {
        final CountDownLatch latch = new CountDownLatch(1);
        final User[] user = new User[1];
        user[0] = null;
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/user?id="+userId, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                user[0] = JSON.parseObject(response,User.class);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("getUser","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user[0];
    }

    @Override
    public boolean insertUser(User obj) {
        return true;
    }
}
