package com.neu.assigment.controller;

import com.neu.assigment.bean.User;
import com.neu.assigment.dto.ResultDTO;
import com.neu.assigment.dto.LoginUser;
import com.neu.assigment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    @ResponseBody
    public ResultDTO login(@RequestBody LoginUser loginUser){
        ResultDTO resultDTO=new ResultDTO();
        if (loginService.checkExist(loginUser)){
            User user=loginService.login(loginUser);
            resultDTO.setUser(user);
            if (user!=null){
                resultDTO.setState(1);
                resultDTO.getUser().setPassword(null);     //返回用户信息时不携带真实密码信息
                resultDTO.setMsg("登录成功！");
            }else {
                resultDTO.setState(0);
                resultDTO.setMsg("登陆失败，用户名或密码错误");
            }
        }else {
            resultDTO.setState(2);
            resultDTO.setMsg("登陆失败，用户尚未注册");
        }
        return resultDTO;
    }

    @RequestMapping("register")
    @ResponseBody
    public ResultDTO register(@RequestBody LoginUser loginUser){
        ResultDTO resultDTO=new ResultDTO();
        if (loginService.checkExist(loginUser)){
            resultDTO.setMsg("注册失败，该用户名已被注册，换一个试试？");
            resultDTO.setState(3);
        }else {
            if (loginService.register(loginUser)==1){
                resultDTO.setMsg("注册成功，赶快登录吧");
                resultDTO.setState(4);
            }else {
                resultDTO.setMsg("注册失败，请重试");
                resultDTO.setState(5);
            }
        }
        return resultDTO;
    }
}
