package com.zerod.codemonkey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerod.codemonkey.entity.Table;
import com.zerod.codemonkey.mapper.TableMapper;
import com.zerod.codemonkey.service.TableService;

/**
 * 表Service实现类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 2.0
 *
 */
@Service
public class TableServiceImpl implements TableService {

  @Autowired
  private TableMapper tableMapper;
  
  @Override
  public List<Table> listTableBySchema(String tableSchema) {
    return tableMapper.listTableBySchema(tableSchema);
  }

}
