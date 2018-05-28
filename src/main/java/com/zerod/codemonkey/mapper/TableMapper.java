package com.zerod.codemonkey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zerod.codemonkey.entity.Table;

/**
 * 表Mapper
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
public interface TableMapper {

  /**
   * 查询数据库中的表信息
   * 
   * @param tableSchema
   *          数据库名称
   * @return 数据库中的表信息
   */
  List<Table> listTableBySchema(@Param("tableSchema") String tableSchema);
  
}
