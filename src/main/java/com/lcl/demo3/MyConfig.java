package com.lcl.demo3;

import com.lcl.demo3.support.BaseInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/17 9:48
 */
@Configuration
public class MyConfig extends WebMvcConfigurationSupport {

    private final Logger logger = LoggerFactory.getLogger(MyConfig.class);

    @Bean
    public BaseInterceptor baseInterceptor() {
        return new BaseInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
