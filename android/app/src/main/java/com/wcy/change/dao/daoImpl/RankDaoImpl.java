package com.wcy.change.dao.daoImpl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.wcy.change.dao.RankDao;
import com.wcy.change.util.HttpCallbackListener;
import com.wcy.change.util.HttpRequestUtil;

import java.util.concurrent.CountDownLatch;

public class RankDaoImpl implements RankDao {
    @Override
    public int getCurrRank(String userID) {
        final CountDownLatch latch = new CountDownLatch(1);
        final int[] rank = new int[1];
        rank[0] = 0;
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/userRank?userid="+userID, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                rank[0] = (int) JSON.parse(response);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("getCurrRank","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rank[0];
    }

    @Override
    public int getCount(String userID) {
        final CountDownLatch latch = new CountDownLatch(1);
        final int[] count = new int[1];
        count[0] = 0;
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/userCount?userid="+userID, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                count[0] = (int) JSON.parse(response);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("getCount","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count[0];
    }
}
