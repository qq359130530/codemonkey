package com.zerod.codemonkey.service.impl;

import com.zerod.codemonkey.entity.Column;
import com.zerod.codemonkey.service.TypeConvertor;
import com.zerod.codemonkey.vo.Property;

/**
 * Db类型->Java类型转换器
 * 
 * @since 2018年5月25日
 * @author 赵凡
 * @version 1.0
 *
 */
public abstract class DbTypeConvertor implements TypeConvertor {

  @Override
  public Property convert(Object source) {
    if (source instanceof Column) {
      return convert((Column) source);
    }

    throw new RuntimeException("source not's Column instance!");
  }

  /**
   * Db类型->Java类型
   * 
   * @param column
   *          DB Column实例
   * @return Java实体属性
   */
  protected abstract Property convert(Column column);

}
