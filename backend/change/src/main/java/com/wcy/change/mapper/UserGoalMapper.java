package com.wcy.change.mapper;

import com.wcy.change.pojo.UserGoal;
import com.wcy.change.pojo.UserGoalExample;
import com.wcy.change.pojo.UserGoalKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGoalMapper {
    long countByExample(UserGoalExample example);

    int deleteByExample(UserGoalExample example);

    int deleteByPrimaryKey(UserGoalKey key);

    int insert(UserGoal record);

    int insertSelective(UserGoal record);

    List<UserGoal> selectByExample(UserGoalExample example);

    UserGoal selectByPrimaryKey(UserGoalKey key);

    int updateByExampleSelective(@Param("record") UserGoal record, @Param("example") UserGoalExample example);

    int updateByExample(@Param("record") UserGoal record, @Param("example") UserGoalExample example);

    int updateByPrimaryKeySelective(UserGoal record);

    int updateByPrimaryKey(UserGoal record);
}