package org.lanqiao.wuliu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author zooqi
 *
 */
public class ParseUtils {

	/**
	 * 将来自表单的输入转化为{@link java.lang.Integer}类型, 如attribute不合法(为null或为""或为非整数字符串),
	 * 一律返回整数0.
	 * 
	 * @param attribute
	 *            属性
	 * @return
	 */
	public static int parseInt(String attribute) {
		if (attribute == null || attribute.equals("")) {
			return 0;
		}

		int value = 0;
		try {
			value = Integer.parseInt(attribute);
		} catch (NumberFormatException e) {
			return 0;
		}
		return value;
	}

	/**
	 * 将来自表单的输入转化为{@link java.lang.Double}类型, 如attribute不合法(为null或为""或为非浮点数字符串),
	 * 一律返回浮点数0.0.
	 * 
	 * @param attribute
	 *            属性
	 * @return
	 */
	public static double parseDouble(String attribute) {
		if (attribute == null || attribute.equals("")) {
			return 0.0;
		}

		double value = 0.0;
		try {
			value = Double.parseDouble(attribute);
		} catch (NumberFormatException e) {
			return 0.0;
		}
		return value;
	}

	/**
	 * 将符合yyyy-MM-dd格式的日期字符串dateStr解析为{@link java.util.Date}对象,
	 * 如果dateStr不合法，则返回null
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate(String dateStr) {
		if (dateStr == null || dateStr.equals("")) {
			return null;
		}

		Date date;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * 将来自表单的输入转化为合法的字符串(保证不出现{@link java.lang.NullPointerExcepftion})
	 * 
	 * @return
	 */
	public static String toLegalString(String str) {
		if (str != null) {
			return str;
		}
		return "";
	}

}
