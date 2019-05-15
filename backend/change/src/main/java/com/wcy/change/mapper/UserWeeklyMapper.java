package com.wcy.change.mapper;

import com.wcy.change.pojo.UserWeekly;
import com.wcy.change.pojo.UserWeeklyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWeeklyMapper {
    long countByExample(UserWeeklyExample example);

    int deleteByExample(UserWeeklyExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserWeekly record);

    int insertSelective(UserWeekly record);

    List<UserWeekly> selectByExample(UserWeeklyExample example);

    UserWeekly selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserWeekly record, @Param("example") UserWeeklyExample example);

    int updateByExample(@Param("record") UserWeekly record, @Param("example") UserWeeklyExample example);

    int updateByPrimaryKeySelective(UserWeekly record);

    int updateByPrimaryKey(UserWeekly record);
}