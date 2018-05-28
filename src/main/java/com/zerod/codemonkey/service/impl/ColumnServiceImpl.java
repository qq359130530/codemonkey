package com.zerod.codemonkey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerod.codemonkey.entity.Column;
import com.zerod.codemonkey.entity.Table;
import com.zerod.codemonkey.mapper.ColumnMapper;
import com.zerod.codemonkey.service.ColumnService;

/**
 * 列Service实现类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 2.0
 *
 */
@Service
public class ColumnServiceImpl implements ColumnService {

  @Autowired
  private ColumnMapper columnMapper;

  @Override
  public List<Column> listColumnByTable(Table table) {
    return columnMapper.listColumnByTable(table);
  }
  
}
