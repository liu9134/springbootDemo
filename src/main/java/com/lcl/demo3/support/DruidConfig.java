package com.lcl.demo3.support;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/27 17:46
 */
@Configuration
public class DruidConfig {

    /**
     * 加入到Spring容器中，并扫描spring.datasource前缀的配置
     * @return
     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druid(){
//        return new DruidDataSource();
//    }
}
