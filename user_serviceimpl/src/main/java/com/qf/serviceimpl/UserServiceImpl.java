package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.entity.User;
import com.qf.mapper.UserMaper;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 王铭
 * @Date 2019/6/29
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMaper userMaper;

    @Override
    public int insertUser(User user) {
        return userMaper.insert(user);
    }

    @Override
    public List<User> queryList() {
        return userMaper.selectList(null);
    }

    @Override
    public User findOne(User user) {
        return null;
    }


}
