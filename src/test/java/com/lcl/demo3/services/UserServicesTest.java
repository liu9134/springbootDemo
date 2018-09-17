package com.lcl.demo3.services;

import com.lcl.demo3.BaseServicesTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/29 10:48
 */
public class UserServicesTest extends BaseServicesTest {

    @Autowired
    private UserServices userServices;

    @Test
    public void testAddUser(){
        try {
            Assert.assertEquals(1,userServices.addUser("张三","123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
