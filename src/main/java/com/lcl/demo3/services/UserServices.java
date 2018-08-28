package com.lcl.demo3.services;

import com.lcl.demo3.model.ResultModel;

import javax.xml.transform.Result;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/27 16:17
 */
public interface UserServices {
    int addUser(String loginName,String passworld) throws Exception;

    ResultModel getUserList(Integer pageIndex, Integer pageSize) throws Exception;
}
