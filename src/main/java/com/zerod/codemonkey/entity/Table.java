package com.zerod.codemonkey.entity;

import java.util.List;

/**
 * 数据库表实体类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
public class Table {

  private String tableName;// 表名

  private String tableSchema;// 所属DB名称

  private String tableComment;// 表备注

  private List<Column> columns;// 列信息

  /**
   * 获取表名
   * 
   * @return 表名
   */
  public String getTableName() {
    return tableName;
  }

  /**
   * 设置表名
   * 
   * @param tableName
   *          表名
   */
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

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
   * 获取表备注
   * 
   * @return 表备注
   */
  public String getTableComment() {
    return tableComment;
  }

  /**
   * 设置表备注
   * 
   * @param tableComment
   *          表备注
   */
  public void setTableComment(String tableComment) {
    this.tableComment = tableComment;
  }

  /**
   * 获取列信息
   * 
   * @return 列信息
   */
  public List<Column> getColumns() {
    return columns;
  }

  /**
   * 设置列信息
   * 
   * @param columns
   *          列信息
   */
  public void setColumns(List<Column> columns) {
    this.columns = columns;
  }

  @Override
  public String toString() {
    return "Schema[" + this.tableSchema + "] -> Table[name=" + this.tableName + ", comment=" + tableComment + "]";
  }

}
