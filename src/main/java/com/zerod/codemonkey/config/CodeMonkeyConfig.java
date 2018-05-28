package com.zerod.codemonkey.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Code Monkey配置类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
@Configuration
@ConfigurationProperties(prefix = "codemonkey")
public class CodeMonkeyConfig {

  private String tableSchema;// 数据库名称

  private String tablePrefix;// 表名前缀

  private boolean entityNameRmPrefix;// 实体类名是否删除表前缀

  private String basePackage;// 应用根包

  private String basePath;// 生成文件的目录

  private List<String> templateNames;// 模板名称列表

  /**
   * 获取数据库名称
   * 
   * @return 数据库名称
   */
  public String getTableSchema() {
    return tableSchema;
  }

  /**
   * 设置数据库名称
   * 
   * @param tableSchema
   *          数据库名称
   */
  public void setTableSchema(String tableSchema) {
    this.tableSchema = tableSchema;
  }

  /**
   * 获取表名前缀
   * 
   * @return 表名前缀
   */
  public String getTablePrefix() {
    return tablePrefix;
  }

  /**
   * 设置表名前缀
   * 
   * @param tablePrefix
   *          表名前缀
   */
  public void setTablePrefix(String tablePrefix) {
    this.tablePrefix = tablePrefix;
  }

  /**
   * 实体类名是否删除表名前缀
   * 
   * @return 删除返回true，否则返回false
   */
  public boolean isEntityNameRmPrefix() {
    return entityNameRmPrefix;
  }

  /**
   * 设置实体类名是否删除表名前缀
   * 
   * @param entityNameRmPrefix
   *          实体类名是否删除表名前缀
   */
  public void setEntityNameRmPrefix(boolean entityNameRmPrefix) {
    this.entityNameRmPrefix = entityNameRmPrefix;
  }

  /**
   * 获取应用根包
   * 
   * @return 应用根包
   */
  public String getBasePackage() {
    return basePackage;
  }

  /**
   * 设置应用根包
   * 
   * @param basePackage
   *          应用根包
   */
  public void setBasePackage(String basePackage) {
    this.basePackage = basePackage;
  }

  /**
   * 获取生成文件的路径
   * 
   * @return 生成文件的路径
   */
  public String getBasePath() {
    return basePath;
  }

  /**
   * 设置生成文件的路径
   * 
   * @param targetPath
   *          生成文件的路径
   */
  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  /**
   * 获取模板名称列表
   * 
   * @return 模板名称列表
   */
  public List<String> getTemplateNames() {
    return templateNames;
  }

  /**
   * 设置模板名称列表
   * 
   * @param templateNames
   *          模板名称列表
   */
  public void setTemplateNames(List<String> templateNames) {
    this.templateNames = templateNames;
  }

}
