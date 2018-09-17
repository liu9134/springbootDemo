package com.lcl.demo3.util;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    public static String getImageStr(String imgSrcPath){
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgSrcPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.getImageStr("C:/Users/Administrator/Desktop/HTML/index.png"));
    }
}
