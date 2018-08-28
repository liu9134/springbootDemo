package com.lcl.demo3.controller;

import com.lcl.demo3.model.ResultModel;
import com.lcl.demo3.model.User;
import com.lcl.demo3.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: 用户业务
 * @date 2018/8/27 16:14
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "add")
    public ResultModel addUser(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "loginName", required = true) String loginName,
                        @RequestParam(value = "password", required = true) String password) throws Exception{
        userServices.addUser(loginName,password);
        return new ResultModel(1000,"成功");
    }

    @RequestMapping(value = "list")
    public ResultModel getUserList(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "pageIndex", defaultValue = "0") Integer pageIndex,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception{
        ResultModel resultModel = userServices.getUserList(pageIndex,pageSize);
        return resultModel;
    }
}
