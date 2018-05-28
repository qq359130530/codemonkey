package com.zerod.codemonkey.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zerod.codemonkey.entity.Column;
import com.zerod.codemonkey.vo.Property;

import static com.zerod.codemonkey.service.TypeConvertor.*;

/**
 * MySQL类型->Java类型转换器
 * 
 * @since 2018年5月25日
 * @author 赵凡
 * @version 1.0
 *
 */
@Service(MYSQL_TYPE_CONVERTOR + TYPE_CONVERTOR_SUFFIX)
public class MySQLTypeConvertor extends DbTypeConvertor {

  private static Map<String, String> COLUMN_MAP_JAVA = new HashMap<>();
  
  private static Map<String, String> JAVA_SIMPLE_MAP_FULL = new HashMap<>();
  
  static {
    COLUMN_MAP_JAVA.put("tinyint", "Byte");
    COLUMN_MAP_JAVA.put("smallint", "Short");
    COLUMN_MAP_JAVA.put("mediumint", "Short");
    COLUMN_MAP_JAVA.put("int", "Integer");
    COLUMN_MAP_JAVA.put("integer", "Integer");
    COLUMN_MAP_JAVA.put("bigint", "Long");
    COLUMN_MAP_JAVA.put("real", "Double");
    COLUMN_MAP_JAVA.put("double", "Double");
    COLUMN_MAP_JAVA.put("float", "Float");
    COLUMN_MAP_JAVA.put("decimal", "BigDecimal");
    COLUMN_MAP_JAVA.put("numeric", "BigDecimal");
    COLUMN_MAP_JAVA.put("char", "String");
    COLUMN_MAP_JAVA.put("varchar", "String");
    COLUMN_MAP_JAVA.put("text", "String");
    COLUMN_MAP_JAVA.put("date", "LocalDate");
    COLUMN_MAP_JAVA.put("time", "LocalTime");
    COLUMN_MAP_JAVA.put("year", "Integer");
    COLUMN_MAP_JAVA.put("timestamp", "LocalDateTime");
    COLUMN_MAP_JAVA.put("datetime", "LocalDateTime");
    
    JAVA_SIMPLE_MAP_FULL.put("Byte", "java.lang.Byte");
    JAVA_SIMPLE_MAP_FULL.put("Short", "java.lang.Short");
    JAVA_SIMPLE_MAP_FULL.put("Integer", "java.lang.Integer");
    JAVA_SIMPLE_MAP_FULL.put("Long", "java.lang.Long");
    JAVA_SIMPLE_MAP_FULL.put("Double", "java.lang.Double");
    JAVA_SIMPLE_MAP_FULL.put("Float", "java.lang.Float");
    JAVA_SIMPLE_MAP_FULL.put("BigDecimal", "java.math.BigDecimal");
    JAVA_SIMPLE_MAP_FULL.put("String", "java.lang.String");
    JAVA_SIMPLE_MAP_FULL.put("LocalDate", "java.time.LocalDate");
    JAVA_SIMPLE_MAP_FULL.put("LocalTime", "java.time.LocalTime");
    JAVA_SIMPLE_MAP_FULL.put("LocalDateTime", "java.time.LocalDateTime");
  }
  
  @Override
  protected Property convert(Column column) {
    Property p = new Property();
    // 设置属性名称
    p.setName(column.getColumnName());
    // 设置属性描述
    p.setDesc(column.getColumnName());
    
    // 通过列类型计算Java类型
    String columnType = column.getDataType();
    String javaType = COLUMN_MAP_JAVA.get(columnType);
    String fullJavaType = javaType == null ? null : JAVA_SIMPLE_MAP_FULL.get(javaType);
    
    // 设置简单类型
    p.setType(javaType);
    // 设置完整类型
    p.setFullType(fullJavaType);
    return p;
  }
  
}
