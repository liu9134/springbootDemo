package com.lcl.demo3.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("132");
        list.add("132");
        list.add("132");
        list.add("132");
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

//    public static void main(String[] args) {
//        System.out.println("当前时间轴："+new Date().getTime()/1000);
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        map.put(1,10);
//        map.put(2,20);
//        System.out.println("entrySet ,iterator遍历:");
//        Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
//        while (it.hasNext()){
//            Map.Entry<Integer,Integer> entry = it.next();
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }
//        System.out.println("keySet遍历:");
//        for (Integer in:map.keySet()) {
//            System.out.println(in + ":" + map.get(in));
//        }
//        System.out.println("entrySet遍历：");
//        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }
//
//        System.out.println("values遍历(只能获取value):");
//        for (Integer in:map.values()) {
//            System.out.println(in);
//        }
//
//        System.out.println("斐波那契数列求第N数字：");
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println("初始："+list.toString());
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入数字：" );
//        Integer scan = scanner.nextInt();
//        if(scan<=2){
//            System.out.println("1");
//            return;
//        }else{
//            for (int i=0;i<scan;i++){
//                if(list.size()-1<i){
//                    int num = list.get(i-2) + list.get(i-1);
//                    list.add(num);
//                }
//            }
//        }
//        System.out.println("计算后："+list.toString());
//        System.out.println("结果为："+list.get(scan-1));
//    }

}
