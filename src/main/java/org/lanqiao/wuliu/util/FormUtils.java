package org.lanqiao.wuliu.util;

/**
 * 
 * @author zooqi
 *
 */
public class FormUtils {

	/**
	 * 将来自表单的输入转化为{@code java.lang.Integer}类型, 如attribute不合法(为null或为""或为非整数字符串),
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
	 * 将来自表单的输入转化为{@code java.lang.Double}类型, 如attribute不合法(为null或为""或为非浮点数字符串),
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
}
