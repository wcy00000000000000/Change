package com.wcy.change.dao;

public interface RankDao {
    int getCurrRank(String userID);
    int getCount(String userID);  //获取最长连续天数
}
