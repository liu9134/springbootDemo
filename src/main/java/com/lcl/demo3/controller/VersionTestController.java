package com.lcl.demo3.controller;

import com.lcl.demo3.support.version.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/30 13:48
 */
@RestController
@RequestMapping(value = "/{version}/")
public class VersionTestController {

    @RequestMapping(value = "hello")
    public ModelAndView index() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "我是V1版本");
        mv.setViewName("html/index");
        return mv;
    }

    @ApiVersion(2)
    @RequestMapping(value = "hello")
    public ModelAndView index2() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "我是V2版本");
        mv.setViewName("html/index");
        return mv;
    }

    @ApiVersion(3)
    @RequestMapping(value = "hello")
    public ModelAndView index3() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "我是V3版本");
        mv.setViewName("html/index");
        return mv;
    }
}
