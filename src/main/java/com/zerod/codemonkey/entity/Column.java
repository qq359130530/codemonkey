package com.zerod.codemonkey.entity;

/**
 * 栏目实体类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 2.0
 *
 */
public class Column {

  private String tableSchema;// 数据库名称

  private String tableName;// 表名

  private String columnName;// 列名

  private String dataType;// 数据类型

  private Long characterMaximumLength;// 字符最大长度

  private Long numericPrecision;// 总位数

  private Long numericScale;// 小数位数

  private boolean nullable;// 是否可以为空

  private String columnComment;// 列注释

  private String columnKey;// 列键

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
   * 获取列名
   * 
   * @return 列名
   */
  public String getColumnName() {
    return columnName;
  }

  /**
   * 设置列名
   * 
   * @param columnName
   *          列名
   */
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  /**
   * 获取数据类型
   * 
   * @return 数据类型
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * 设置数据类型
   * 
   * @param dataType
   *          数据类型
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  /**
   * 获取字符最大长度
   * 
   * @return 字符最大长度
   */
  public Long getCharacterMaximumLength() {
    return characterMaximumLength;
  }

  /**
   * 设置字符最大长度
   * 
   * @param characterMaximumLength
   *          字符最大长度
   */
  public void setCharacterMaximumLength(Long characterMaximumLength) {
    this.characterMaximumLength = characterMaximumLength;
  }

  /**
   * 获取数值位数
   * 
   * @return 数值位数
   */
  public Long getNumericPrecision() {
    return numericPrecision;
  }

  /**
   * 设置数值位数
   * 
   * @param numericPrecision
   *          数值位数
   */
  public void setNumericPrecision(Long numericPrecision) {
    this.numericPrecision = numericPrecision;
  }

  /**
   * 获取小数位数
   * 
   * @return 小数位数
   */
  public Long getNumericScale() {
    return numericScale;
  }

  /**
   * 设置小数位数
   * 
   * @param numericScale
   *          小数位数
   */
  public void setNumericScale(Long numericScale) {
    this.numericScale = numericScale;
  }

  /**
   * 是否可以为空
   * 
   * @return 是否可以为空
   */
  public boolean isNullable() {
    return nullable;
  }

  /**
   * 设置是否可以为空
   * 
   * @param nullable
   *          是否可以为空
   */
  public void setNullable(boolean nullable) {
    this.nullable = nullable;
  }

  /**
   * 获取列注释
   * 
   * @return 列注释
   */
  public String getColumnComment() {
    return columnComment;
  }

  /**
   * 设置列注释
   * 
   * @param columnComment
   *          列注释
   */
  public void setColumnComment(String columnComment) {
    this.columnComment = columnComment;
  }

  /**
   * 获取列键
   * 
   * @return 列键
   */
  public String getColumnKey() {
    return columnKey;
  }

  /**
   * 设置列键
   * 
   * @param columnKey
   *          列键
   */
  public void setColumnKey(String columnKey) {
    this.columnKey = columnKey;
  }

  @Override
  public String toString() {
    return "Column [tableSchema=" + tableSchema + ", tableName=" + tableName + ", columnName=" + columnName
        + ", dataType=" + dataType + ", characterMaximumLength=" + characterMaximumLength + ", numericPrecision="
        + numericPrecision + ", numericScale=" + numericScale + ", nullable=" + nullable + ", columnComment="
        + columnComment + ", columnKey=" + columnKey + "]";
  }

}
