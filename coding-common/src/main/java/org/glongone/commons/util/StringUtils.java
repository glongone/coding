package org.glongone.commons.util;

import java.util.regex.Pattern;

/**
 * @author: glongone
 * @date: 2020/9/1 4:06 afternoon
 * @desc: Tools for processing strings
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    // not number、English、chinese
    private static final Pattern NO_NUMBER_CHARACTER = Pattern.compile("[^0-9a-zA-Z\\u4e00-\\u9fa5]");

    private static final Pattern IS_NUMBER           = Pattern.compile("[0-9]*\\.?[0-9]*");

    private static final String  CHINESE_CHAR        = "[\u4e00-\u9fa5]";

    /**
     * Determine whether a character is a Chinese character
     * PS：Coding range of Chinese characters：[\u4e00-\u9fa5]
     *
     * @param c the char need to be Determine
     * @return chinese(true), not chinese(false)
     */
    public static boolean isChineseChar(char c) {
        return String.valueOf(c).matches(CHINESE_CHAR);
    }

    /**
     * Determine whether a character the first char is a Chinese character
     * don't remove the first space
     *
     * @param str the char need to be Determine
     * @return chinese(true), not chinese(false)
     */
    public static boolean isChineseStr(String str) {
        return str != null && isChineseChar(str.charAt(0));
    }

    /**
     * Determine whether a character at a specific position in a string
     * is a Chinese character
     *
     * @param str the string need to be Determine
     * @param position the position
     * @return chinese(true), not chinese(false)
     */
    public static boolean isChineseStr(String str, int position) {
        return str != null && isChineseChar(str.charAt(position));
    }

    /**
     * Determine whether a character the first char is a Chinese character
     * remove the first space
     *
     * @param str the string need to be Determine
     * @return chinese(true), not chinese(false)
     */
    public static boolean isTrimChineseStr(String str) {
        return isChineseStr(trim(str));
    }

    /**
     * Determine whether the current string contains spaces
     *
     * @param str the string need to be Determine
     * @return no space(true), contains spaces(false)
     */
    public static boolean isNoBlank(String str) {
        return str.length() == str.replaceAll(" ", "").length();
    }

	/**
	 *
	 *
	 * @param obj Object
	 * @return null or obj.toString();
	 */
	public static String valueOf(Object obj) {
		return (obj == null) ? null : obj.toString();
	}
}
