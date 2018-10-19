package com.lcl.demo3.controller;

import com.lcl.demo3.model.ResultModel;
import com.lcl.demo3.support.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: redis测试
 * @date 2018/10/19 16:56
 */
@RestController
@RequestMapping(value = "/redis/")
public class RedisTestController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "add")
    public ResultModel addUser(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value = "key", required = true) String key,
                               @RequestParam(value = "value", required = true) String value) throws Exception{
        redisUtil.set(key,value);
        return new ResultModel(1000,"成功");
    }

}
