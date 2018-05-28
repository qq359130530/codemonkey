package com.zerod.codemonkey.service;

import java.util.List;

import com.zerod.codemonkey.entity.Column;
import com.zerod.codemonkey.entity.Table;

/**
 * 列Service接口
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
public interface ColumnService {

  /**
   * 查询表中的列信息
   * 
   * @param table
   *          表实例
   * @return 列信息
   */
  List<Column> listColumnByTable(Table table);

}
