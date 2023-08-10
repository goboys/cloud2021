package com.boys.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.boys.springcloud.dao"})
public class MyBatisConfig {
}
