package com.wcy.change.mapper;

import com.wcy.change.pojo.Story;
import com.wcy.change.pojo.StoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoryMapper {
    long countByExample(StoryExample example);

    int deleteByExample(StoryExample example);

    int deleteByPrimaryKey(Integer sceneid);

    int insert(Story record);

    int insertSelective(Story record);

    List<Story> selectByExample(StoryExample example);

    Story selectByPrimaryKey(Integer sceneid);

    int updateByExampleSelective(@Param("record") Story record, @Param("example") StoryExample example);

    int updateByExample(@Param("record") Story record, @Param("example") StoryExample example);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKey(Story record);
}