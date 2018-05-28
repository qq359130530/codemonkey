package com.zerod.codemonkey.service;

import com.zerod.codemonkey.vo.Property;

/**
 * 其它类型->Java类型转换器
 * 
 * @since 2018年5月25日
 * @author 赵凡
 * @version 1.0
 *
 */
public interface TypeConvertor {
  
  /**
   * 类型转换器后缀
   * 
   */
  public static final String TYPE_CONVERTOR_SUFFIX = "TypeConvertor";
  
  /**
   * MySQL类型转换器类型
   * 
   */
  public static final String MYSQL_TYPE_CONVERTOR = "mysql";

  /**
   * 其它类型->Java类型转换
   * 
   * @param source
   *          原对象
   * @return Java实体对象属性
   */
  public Property convert(Object source);
  
  /**
   * 获取转换器类型
   * 
   * @param prefix
   *          类型前缀
   * @return 转换器类型
   */
  public static String getConvertorType(String prefix) {
    return prefix.concat("TypeConvertor");
  }

}
