package com.zerod.codemonkey.service;

import java.util.List;

import com.zerod.codemonkey.entity.Table;

/**
 * 表Service接口
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
public interface TableService {

  /**
   * 查询数据库中的表列表
   * 
   * @param tableSchema
   *          数据库名称
   * @return 数据库中的表列表
   */
  List<Table> listTableBySchema(String tableSchema);

}
