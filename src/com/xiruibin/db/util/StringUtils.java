package com.xiruibin.db.util;

/**
 * String 常用操作工具集
 */
public final class StringUtils {

    /**
     * <code>
     * <p>
     * 判断一个String对象是否有长度.
     * </p>
     * NULL return false
     * ''   return false
     * " "  return false
     * </code>
     * 
     * @param s
     * @return
     */
    public static boolean hasLength(String s) {
        return !ObjectUtils.isNull(s) && s.trim().length() > 0;
    }
}
