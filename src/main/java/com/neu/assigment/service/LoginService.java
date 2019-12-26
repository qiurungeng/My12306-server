package com.neu.assigment.service;

import com.neu.assigment.bean.User;
import com.neu.assigment.dto.LoginUser;

public interface LoginService {
    boolean checkExist(LoginUser user);
    User login(LoginUser loginUser);
    int register(LoginUser loginUser);
}
