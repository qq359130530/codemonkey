package com.zerod.codemonkey.mapper;

import java.util.List;

import com.zerod.codemonkey.entity.Column;
import com.zerod.codemonkey.entity.Table;

/**
 * 列Mapper
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
public interface ColumnMapper {

  /**
   * 查询指定表的列信息
   * 
   * @param table
   *          表信息
   * @return 指定表的列信息
   */
  List<Column> listColumnByTable(Table table);

}
