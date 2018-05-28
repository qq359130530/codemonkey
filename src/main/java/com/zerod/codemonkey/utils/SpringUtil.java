package com.zerod.codemonkey.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.zerod.codemonkey.service.TypeConvertor;

import static com.zerod.codemonkey.service.TypeConvertor.*;

/**
 * 类型转换器工厂类
 * 
 * @since 2018年5月25日
 * @author 赵凡
 * @version 1.0
 *
 */
@Component
public class SpringUtil implements ApplicationContextAware {

  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringUtil.context = applicationContext;
  }

  /**
   * 获取类型转换器
   * 
   * @param convertorType
   *          转换器类型
   * @see TypeConvertor
   * @return 类型转换器
   */
  public static TypeConvertor getTypeConvertor(String convertorType) {
    return context.getBean(convertorType.concat(TYPE_CONVERTOR_SUFFIX), TypeConvertor.class);
  }

  /**
   * 通过类型获取Bean实例
   * 
   * @param clazz
   *          字节码类型
   * @return Bean实例
   */
  public static <T> T getBean(Class<T> clazz) {
    return context.getBean(clazz);
  }

}
