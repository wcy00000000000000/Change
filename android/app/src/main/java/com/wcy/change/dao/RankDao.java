package com.wcy.change.dao;

import com.wcy.change.pojo.Rank;

import java.util.List;

public interface RankDao {
    int getCurrRank(String userID);
    int getCount(String userID);  //获取最长连续天数
    List<Rank> getRank();
    Rank getAllDays(String uid);
}
