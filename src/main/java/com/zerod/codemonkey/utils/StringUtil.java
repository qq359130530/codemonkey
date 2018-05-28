package com.zerod.codemonkey.utils;

/**
 * 字符串工具类
 * 
 * @since 2018年5月24日
 * @author 赵凡
 * @version 2.0
 *
 */
public class StringUtil {

  /**
   * 下划线式字符串转驼峰式字符串
   * 
   * @param underscore
   *          下划线式字符串
   * @param firstUpper
   *          驼峰式字符串首字母是否大写
   * @return 驼峰式字符串
   */
  public static String underscoreToCamelCase(String underscore, boolean firstUpper) {
    char[] chars = underscore.toCharArray();
    
    StringBuilder results = new StringBuilder();
    for (int idx = 0; idx < chars.length; idx ++) {
      if (idx == 0 && firstUpper) {
        // 首字母转大写操作
        chars[0] = Character.toUpperCase(chars[0]); 
      }
      
      // 遇到下划线把下一个字符转为大写
      if (chars[idx] == '_') {
        results.append(Character.toUpperCase(chars[++idx]));
        continue;
      }
      
      results.append(chars[idx]);
    }
    
    return results.toString();
  }
  
  /**
   * 下划线式字符串转首字母大写的驼峰式字符串
   * 
   * @param underscore
   *          下划线式字符串
   * @return 首字母大写的驼峰式字符串
   */
  public static String underscoreToCamelCase(String underscore) {
    return underscoreToCamelCase(underscore, true);
  }

}
