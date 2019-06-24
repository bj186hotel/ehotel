package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer artid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer artid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}