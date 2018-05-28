package com.zerod.codemonkey.vo;

/**
 * Java实体对象属性类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 2.0
 *
 */
public class Property {

  private String name;// 属性名称

  private String desc;// 属性描述

  private String type;// 属性类型

  private String fullType;// 属性完全限定类型

  /**
   * 获取属性名称
   * 
   * @return 属性名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置属性名称
   * 
   * @param name
   *          属性名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取属性描述
   * 
   * @return 属性描述
   */
  public String getDesc() {
    return desc;
  }

  /**
   * 设置属性描述
   * 
   * @param desc
   *          属性描述
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

  /**
   * 获取属性类型
   * 
   * @return 属性类型
   */
  public String getType() {
    return type;
  }

  /**
   * 设置属性类型
   * 
   * @param type
   *          属性类型
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * 获取属性完全限定类型
   * 
   * @return 属性完全限定类型
   */
  public String getFullType() {
    return fullType;
  }

  /**
   * 设置属性完全限定类型
   * 
   * @param fullType
   *          属性完全限定类型
   */
  public void setFullType(String fullType) {
    this.fullType = fullType;
  }

}
