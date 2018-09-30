package com.lcl.demo3.support.version;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 版本控制
 * Created by liuchonglong on 2018/09/30.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

    /**
     * 标识版本号
     * @return
     */
    int value();
}
