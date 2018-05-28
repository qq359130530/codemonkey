package com.zerod.codemonkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zerod.codemonkey.service.CodeMonkeyService;

/**
 * 应用启动类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
    CodeMonkeyService codeMonkeyService = ctx.getBean(CodeMonkeyService.class);
    codeMonkeyService.gen();
  }
  
}
