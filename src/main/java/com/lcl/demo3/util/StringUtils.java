package com.lcl.demo3.util;

import java.util.UUID;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/27 16:26
 */
public class StringUtils {

    /**
     * 获取uuid
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
