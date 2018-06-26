package com.kangaroo.utils;

import org.apache.commons.lang3.StringUtils;

public class CommonStringUtils {

	  /**
     * 将字符串首字母小写
     */
    public static String toLowerCaseFirst(String str) {
    	if (StringUtils.isBlank(str)||Character.isLowerCase(str.charAt(0))) {
			return str;
		}
        return new StringBuffer().append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString() ;
    }

    /**
     * 将字符串首字母大写
     */
    public static String toUpperCaseFirst(String str) {
    	if (StringUtils.isBlank(str)||Character.isUpperCase(str.charAt(0))) {
			return str;
		}
        return new StringBuffer().append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString() ;
    }
}
