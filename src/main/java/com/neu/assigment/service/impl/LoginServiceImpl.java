package com.neu.assigment.service.impl;

import com.neu.assigment.bean.User;
import com.neu.assigment.dto.LoginUser;
import com.neu.assigment.service.LoginService;
import com.neu.assigment.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean checkExist(LoginUser loginUser) {
        User user=new User();
        user.setUsername(loginUser.getUsername());
        return userMapper.selectCount(user)>0;
    }

    @Override
    public User login(LoginUser loginUser) {
        User user=new User();
        user.setUsername(loginUser.getUsername());
        user.setPassword(loginUser.getPassword());
        return userMapper.selectOne(user);
    }

    @Override
    public int register(LoginUser loginUser) {
        User user=new User();
        user.setUsername(loginUser.getUsername());
        user.setPassword(loginUser.getPassword());
        int insert = userMapper.insert(user);
        return insert;
    }
}
