package com.asisinfo.datasource.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan(value = "com.asisinfo.datasource.demo.mapper")
@Configuration
public class MyBatisConfig {

    //配置mybatis 类似spring里的mybatis的全局配置文件
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        /*
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰
                configuration.setMapUnderscoreToCamelCase(true);
            }

         */
        return configuration -> {
            //开启驼峰
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }
}
