package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}