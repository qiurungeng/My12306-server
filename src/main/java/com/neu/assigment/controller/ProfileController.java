package com.neu.assigment.controller;

import com.neu.assigment.bean.User;
import com.neu.assigment.dto.ResultDTO;
import com.neu.assigment.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @RequestMapping("changeProfile")
    @ResponseBody
    public ResultDTO changeProfile(@RequestBody User user){
        ResultDTO resultDTO=new ResultDTO();
        int i = profileService.changeProfile(user);
        if (i==1){
            resultDTO.setState(6);
            resultDTO.setMsg("个人信息修改成功");
        }else {
            resultDTO.setState(7);
            resultDTO.setMsg("个人信息修改失败");
        }
        return resultDTO;
    }
}
