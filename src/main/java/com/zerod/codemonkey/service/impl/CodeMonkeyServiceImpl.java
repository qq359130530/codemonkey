package com.zerod.codemonkey.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerod.codemonkey.config.CodeMonkeyConfig;
import com.zerod.codemonkey.entity.Column;
import com.zerod.codemonkey.entity.Table;
import com.zerod.codemonkey.service.CodeMonkeyService;
import com.zerod.codemonkey.service.ColumnService;
import com.zerod.codemonkey.service.TableService;
import com.zerod.codemonkey.service.TypeConvertor;
import com.zerod.codemonkey.utils.FreeMarkerUtil;
import com.zerod.codemonkey.utils.StringUtil;
import com.zerod.codemonkey.utils.SpringUtil;
import com.zerod.codemonkey.vo.Entity;
import com.zerod.codemonkey.vo.Property;

/**
 * CodeMonkey业务Service实现类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 1.0
 *
 */
@Service
public class CodeMonkeyServiceImpl implements CodeMonkeyService {

  private static final Logger LOG = LoggerFactory.getLogger(CodeMonkeyService.class);
  
  @Autowired
  private TableService tableService;
  
  @Autowired
  private ColumnService columnService;
  
  @Autowired
  private CodeMonkeyConfig config;
  
  @Autowired
  private FreeMarkerUtil freeMarkerUtil;
  
  @Override
  public void gen() {
    // 初始化表对象
    List<Table> tables = initTables();
    // Table -> Entity
    List<Entity> entitys = convert(tables);
    // 生成文件
    genFile(entitys);
  }

  //生成文件
  private void genFile(List<Entity> entitys) {
    String basePath = config.getBasePath();
    entitys.parallelStream().forEach(entity -> {
      List<String> templateNames = config.getTemplateNames();
      for (int i = 0; i < templateNames.size(); i++) {
        freeMarkerUtil.genFile(templateNames.get(i), basePath, entity);
      }
    });
  }

  // Table -> Entity
  private List<Entity> convert(List<Table> tables) {
    return tables.parallelStream().map(table -> {
      // 初始化实体基础属性
      Entity entity = initEntity(table);
      // 初始化实体属性
      initEntityProperties(table, entity);
      return entity;
    }).collect(toList());
  }

  //初始化实体属性
  private void initEntityProperties(Table table, Entity entity) {
    // 获取类型转换器
    TypeConvertor convertor = SpringUtil.getTypeConvertor("mysql");
    
    List<Property> props = table.getColumns().stream().map(column -> {
      // Column -> Entity Property
      return convertor.convert(column);
    }).collect(toList());
    entity.setProperties(props);
  }

  // 初始化实体基础属性
  private Entity initEntity(Table table) {
    Entity entity = new Entity();
    entity.setClassName(StringUtil.underscoreToCamelCase(table.getTableName()));
    entity.setPackageName(config.getBasePackage().concat(".entity"));
    entity.setFullName(entity.getPackageName().concat(".").concat(entity.getClassName()));
    entity.setModuleName(table.getTableComment());
    entity.setSource(table);
    return entity;
  }

  // 初始化表信息
  private List<Table> initTables() {
    LOG.info("初始化表信息...");
    
    // 查询数据库中的表信息
    List<Table> tables = tableService.listTableBySchema(config.getTableSchema());
    
    tables.parallelStream().forEach(table -> {
      // 删除表名前缀
      if (config.isEntityNameRmPrefix()) {
        String tableName = table.getTableName();
        String prefix = config.getTablePrefix();
        if (tableName.startsWith(prefix)) {
          table.setTableName(tableName.substring(prefix.length()));
          LOG.info("表{}剔除表前缀后新表名为{}！", tableName, table.getTableName());
        }
      }
      
      // 查询表的列信息
      List<Column> columns = columnService.listColumnByTable(table);
      table.setColumns(columns);
    });
    
    LOG.info("初始化表信息完成！");
    
    return tables;
  }

}
