package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.RoomImg;

public interface RoomImgMapper {
    int deleteByPrimaryKey(Integer rimgid);

    int insert(RoomImg record);

    int insertSelective(RoomImg record);

    RoomImg selectByPrimaryKey(Integer rimgid);

    int updateByPrimaryKeySelective(RoomImg record);

    int updateByPrimaryKey(RoomImg record);
}