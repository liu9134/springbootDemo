package com.lcl.demo3.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/29 11:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    //mock api 模拟http请求
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    //初始化工作
    @Before
    public void setUp() {
        //独立安装测试
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    //测试
    @Test
    public void index() throws Exception {
        MvcResult result = mockMvc.perform(post("/user/test")).andExpect(status().isOk())// 模拟向接口发送请求
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());
    }
}
