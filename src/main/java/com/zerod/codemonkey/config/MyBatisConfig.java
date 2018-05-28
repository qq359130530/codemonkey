package com.zerod.codemonkey.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
@Configuration
@MapperScan(basePackages = "com.zerod.codemonkey.mapper")
public class MyBatisConfig {

}
