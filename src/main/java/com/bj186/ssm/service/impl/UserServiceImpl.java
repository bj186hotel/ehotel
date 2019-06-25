package com.bj186.ssm.service.impl;

import com.bj186.ssm.mapper.UserMapper;
import com.bj186.ssm.pojo.User;
import com.bj186.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author 郑金城
 * @title: UserServiceImpl
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/1115:49
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

}
