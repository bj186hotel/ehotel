package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.RoomType;

import java.util.List;

public interface RoomTypeMapper {
    int deleteByPrimaryKey(Integer rtypeid);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer rtypeid);

    RoomType selectByRtypeName(String rtypeName);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}