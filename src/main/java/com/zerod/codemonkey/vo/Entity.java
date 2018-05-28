package com.zerod.codemonkey.vo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java实体对象
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
public class Entity {

  private String className;// 类名

  private String packageName;// 包名

  private String fullName;// 完全限定名

  private String moduleName;// 模块名称

  private List<Property> properties;// 属性列表

  private Object source;// 原对象

  /**
   * 获取类名
   * 
   * @return 类名
   */
  public String getClassName() {
    return className;
  }

  /**
   * 设置类名
   * 
   * @param className
   *          类名
   */
  public void setClassName(String className) {
    this.className = className;
  }

  /**
   * 获取包名
   * 
   * @return 包名
   */
  public String getPackageName() {
    return packageName;
  }

  /**
   * 设置包名
   * 
   * @param packageName
   *          包名
   */
  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  /**
   * 获取完全限定类名
   * 
   * @return 完全限定类名
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * 设置完全限定类名
   * 
   * @param fullName
   *          完全限定类名
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * 获取模块名称
   * 
   * @return 模块名称
   */
  public String getModuleName() {
    return moduleName;
  }

  /**
   * 设置模块名称
   * 
   * @param moduleName
   *          模块名称
   */
  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  /**
   * 获取实体属性列表
   * 
   * @return 实体属性列表
   */
  public List<Property> getProperties() {
    return properties;
  }

  /**
   * 设置实体属性列表
   * 
   * @param properties
   *          实体属性列表
   */
  public void setProperties(List<Property> properties) {
    this.properties = properties;
  }

  /**
   * 获取原对象
   * 
   * @return 原对象
   */
  public Object getSource() {
    return source;
  }

  /**
   * 设置原对象
   * 
   * @param source
   *          原对象
   */
  public void setSource(Object source) {
    this.source = source;
  }
  
  /**
   * Entity -> Map
   * 
   * @return Map
   */
  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      try {
        Object value = field.get(this);
        map.put(field.getName(), value);
      } catch (IllegalArgumentException | IllegalAccessException e) {
        throw new RuntimeException("对象转Map失败！", e);
      }
    }
    return map;
  }

}
