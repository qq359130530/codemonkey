package com.zerod.codemonkey.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zerod.codemonkey.config.CodeMonkeyConfig;
import com.zerod.codemonkey.vo.Entity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * FreeMarker工具类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 2.0
 *
 */
@Component
public class FreeMarkerUtil {

  private static final Logger LOG = LoggerFactory.getLogger(FreeMarkerUtil.class);

  @Autowired
  private Configuration cfg;
  
  @Autowired
  private CodeMonkeyConfig config;

  /**
   * 生成文件
   * 
   * @param templateName
   *          模板名称
   * @param targetPath
   *          目标路径
   * @param vars
   *          变量池
   */
  private void _genFile(String templateName, String targetPath, Map<String, Object> vars) {
    // 判断父目录是否存在
    File targetFile = new File(targetPath);
    File parentDir = targetFile.getParentFile();
    if (!parentDir.exists()) {
      parentDir.mkdirs();
    }

    // 生成文件
    try (Writer writer = new FileWriter(targetFile)) {
      Template template = cfg.getTemplate(templateName);
      template.process(vars, writer);
      LOG.info("FreeMarker模板生成静态文件[{}]成功！", targetPath);
    } catch (IOException | TemplateException e) {
      LOG.error("FreeMarker模板生成静态文件[" + targetPath + "]失败！", e);
    }
  }

  /**
   * 生成文件
   * 
   * @param templateName
   *          模板文件
   * @param basePath
   *          生成文件的根路径
   * @param entity
   *          Java Entity 对象
   */
  public void genFile(String templateName, String basePath, Entity entity) {
    String templateFileName = null;
    try (StringWriter writer = new StringWriter()) {
      templateFileName = templateName.concat("_name.ftl");
      Template template = cfg.getTemplate(templateFileName);
      Map<String, Object> vars = new HashMap<>();
      vars.put("entity", entity);
      vars.put("config", config);
      template.process(vars, writer);

      String targetPath = basePath.concat("/").concat(writer.toString());
      _genFile(templateName.concat(".ftl"), targetPath, vars);
    } catch (IOException | TemplateException e) {
      LOG.error("FreeMarker模板生成文件名[" + templateFileName + "]失败！", e);
    }
  }

}
