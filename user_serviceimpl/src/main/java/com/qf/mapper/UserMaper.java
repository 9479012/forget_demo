package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.User;

/**
 * @author 王铭
 * @Date 2019/6/29
 */
public interface UserMaper extends BaseMapper<User>{
    User findOne(User user);
}
