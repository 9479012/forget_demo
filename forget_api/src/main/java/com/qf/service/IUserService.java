package com.qf.service;

import com.qf.entity.User;

import java.util.List;

/**
 * @author 王铭
 * @Date 2019/6/29
 */
public interface IUserService {

    int insertUser(User user);

    List<User> queryList();

    User findOne(User user);
}
