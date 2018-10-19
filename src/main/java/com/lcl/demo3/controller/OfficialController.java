package com.lcl.demo3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/14 14:40
 */
@RestController
public class OfficialController {
    @RequestMapping(value = "/")
    public ModelAndView index() throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","第一个templates页面,测试热部署！");
        mv.setViewName("html/index");
        return mv;
    }
}
