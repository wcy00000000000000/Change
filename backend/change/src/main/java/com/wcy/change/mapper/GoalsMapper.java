package com.wcy.change.mapper;

import com.wcy.change.pojo.Goals;
import com.wcy.change.pojo.GoalsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoalsMapper {
    long countByExample(GoalsExample example);

    int deleteByExample(GoalsExample example);

    int deleteByPrimaryKey(Integer goalid);

    int insert(Goals record);

    int insertSelective(Goals record);

    List<Goals> selectByExample(GoalsExample example);

    Goals selectByPrimaryKey(Integer goalid);

    int updateByExampleSelective(@Param("record") Goals record, @Param("example") GoalsExample example);

    int updateByExample(@Param("record") Goals record, @Param("example") GoalsExample example);

    int updateByPrimaryKeySelective(Goals record);

    int updateByPrimaryKey(Goals record);
}