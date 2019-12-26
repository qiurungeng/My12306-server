package com.neu.assigment.dto;

import com.neu.assigment.bean.User;
import lombok.Data;

@Data
public class ResultDTO {
    User user;
    String msg;
    int state;
}
