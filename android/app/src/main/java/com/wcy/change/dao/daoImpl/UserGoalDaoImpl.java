package com.wcy.change.dao.daoImpl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.wcy.change.dao.UserGoalDao;
import com.wcy.change.pojo.User;
import com.wcy.change.pojo.UserGoal;
import com.wcy.change.util.HttpCallbackListener;
import com.wcy.change.util.HttpRequestUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by WCY on 2019/4/13
 */
public class UserGoalDaoImpl implements UserGoalDao {

    @Override
    public List<UserGoal> findAllGoal(String userid) {
        final CountDownLatch latch = new CountDownLatch(1);
        final List<UserGoal>[] list = new ArrayList<>().toArray(new List[1]);

        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/goal/find?id="+userid, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                list[0] = JSON.parseArray(response,UserGoal.class);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("findAllGoal","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list[0];
    }

    @Override
    public UserGoal findGoalById(String goalid) {
        final CountDownLatch latch = new CountDownLatch(1);
        final UserGoal[] goals = new UserGoal[1];
        goals[0] = null;
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/goal/findGoalById?id="+goalid, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                goals[0] = JSON.parseObject(response,UserGoal.class);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("getGoalById","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return goals[0];
    }

    @Override
    public boolean checkin(String goalid) {
        final CountDownLatch latch = new CountDownLatch(1);
        final boolean[] flag = {false};
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/goal/checkin?goalid="+goalid, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                flag[0] = (boolean) JSON.parse(response);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("checkin","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag[0];
    }

    @Override
    public boolean update(UserGoal obj) {
        final CountDownLatch latch = new CountDownLatch(1);
        final boolean[] flag = {false};

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),JSON.toJSONString(obj));

        HttpRequestUtil.getInstance().post(HttpRequestUtil.baseUrl + "/goal/update", requestBody, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                flag[0] = (boolean) JSON.parse(response);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("update","fail");
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag[0];
    }




}
