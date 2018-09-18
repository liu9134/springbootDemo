package com.lcl.demo3.controller;

import com.lcl.demo3.BaseControllerTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/29 11:29
 */
public class UserControllerTest extends BaseControllerTest {

    //测试
    @Test
    public void index() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/user/test")).andExpect(status().isOk())// 模拟向接口发送请求
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());
    }
}
