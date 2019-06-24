package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.RoomType;

public interface RoomTypeMapper {
    int deleteByPrimaryKey(Integer rtypeid);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer rtypeid);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}