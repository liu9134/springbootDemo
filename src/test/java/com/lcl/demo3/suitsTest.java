package com.lcl.demo3;

import com.lcl.demo3.controller.UserControllerTest;
import com.lcl.demo3.services.UserServicesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: 打包测试，注入所有测试类，在这里运行统一测试
 * @date 2018/8/29 10:56
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UserServicesTest.class, UserControllerTest.class})
public class suitsTest {
}
