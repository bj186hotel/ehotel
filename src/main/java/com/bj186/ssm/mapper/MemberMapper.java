package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer memid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer memid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}