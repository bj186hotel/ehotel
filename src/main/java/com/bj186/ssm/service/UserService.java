package com.bj186.ssm.service;

import com.bj186.ssm.pojo.User;

/**
 * @author 郑金城
 * @title: UserService
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/1115:48
 */
public interface UserService {
    /**
     * 用户登录
     * @param userId 用户的id
     * @return 用户对象
     */
    User login(Integer userId);
    void register(User user);
}
