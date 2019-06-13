package com.wcy.change.dao.daoImpl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.wcy.change.dao.RankDao;
import com.wcy.change.pojo.Rank;
import com.wcy.change.util.HttpCallbackListener;
import com.wcy.change.util.HttpRequestUtil;

import java.util.ArrayList;
import java.util.List;
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
    @Override
    public List<Rank> getRank(){
        final CountDownLatch latch = new CountDownLatch(1);
//        final User[] user = new User[1];
        final List<Rank>[] ranks= new List[]{new ArrayList()};
        ranks[0]=null;
//        user[0] = null;
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/rank", new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                ranks[0] = JSON.parseArray(response,Rank.class);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("getRank","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ranks[0];
    }

    @Override
    public Rank getAllDays(String uid){
        final CountDownLatch latch = new CountDownLatch(1);
//        final User[] user = new User[1];
        final Rank[] ranks=new Rank[1];
        ranks[0]=null;
//        user[0] = null;
        HttpRequestUtil.getInstance().get(HttpRequestUtil.baseUrl+"/user/allDay?userid="+uid, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                ranks[0] = JSON.parseObject(response,Rank.class);
                latch.countDown();
            }
            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.i("getUserAllDays","fail");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ranks[0];
    }
}
