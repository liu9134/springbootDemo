package com.lcl.demo3.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcl.demo3.mapper.UserMapper;
import com.lcl.demo3.model.ResultModel;
import com.lcl.demo3.model.User;
import com.lcl.demo3.services.UserServices;
import com.lcl.demo3.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/27 16:18
 */
@Service(value = "UserServices")
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(String loginName, String passworld) throws Exception {
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(passworld);
        user.setUserId(StringUtils.getUUID());
        return userMapper.insert(user);
    }

    @Override
    public ResultModel getUserList(Integer pageIndex, Integer pageSize) throws Exception {
        PageHelper.startPage(pageIndex, pageSize);
        List<User> userList = userMapper.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return new ResultModel(1000, "成功", pageInfo);
    }
}
