package com.neu.assigment.service.impl;

import com.neu.assigment.bean.User;
import com.neu.assigment.service.ProfileService;
import com.neu.assigment.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int changeProfile(User user) {
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",user.getUsername());
        int i = userMapper.updateByExampleSelective(user,example);
        return i;
    }
}
