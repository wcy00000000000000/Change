package com.wcy.change.dao.daoImpl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.wcy.change.dao.UserWeeklyDao;
import com.wcy.change.pojo.UserWeekly;
import com.wcy.change.util.HttpCallbackListener;
import com.wcy.change.util.HttpRequestUtil;

import java.util.concurrent.CountDownLatch;

public class UserWeeklyDaoImpl implements UserWeeklyDao {
    @Override
    public UserWeekly getUserWeek(String uid){
        final CountDownLatch latch = new CountDownLatch(1);
        final UserWeekly[] userWeekly = new UserWeekly[1];
        userWeekly[0] = null;
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/user/week?id="+uid, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                userWeekly[0] = JSON.parseObject(response,UserWeekly.class);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("getUserWeek","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userWeekly[0];
    }
}
