package org.lanqiao.wuliu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.wuliu.util.DBUtils;

/**
 * 基本的CRUD的方法
 * 
 * @author 杨明静
 *
 */
public class BaseDaoImpl{
	/**
	 * 处理sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @return 返回PreparedStatement
	 */
	private PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DBUtils.connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	/**
	 * 处理含占位符的Object数组
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            Object数组
	 * @return 返回PreparedStatement
	 */
	private PreparedStatement setParameter(String sql, Object[] params) {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = getPreparedStatement(sql);
			for (int i = 0; i < params.length; i++) {
				preparedstatement.setObject((i + 1), params[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedstatement;
	}

	/**
	 * 处理含占位符的SQL语句
	 * 
	 * @param preparedStatement
	 * @param sql
	 * @param params
	 */
	protected void setParameter(final PreparedStatement preparedStatement, String sql, Object[] params) {
		if (preparedStatement == null) {
			return;
		}

		try {
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject((i + 1), params[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理含占位符的查询的sql语句
	 * 
	 * @param sql
	 *            含占位符的查询的sql语句
	 * @param params
	 *            参数数组
	 * @return 返回ResultSet结果集
	 */
	public ResultSet select(String sql, Object[] params) {
		ResultSet result = null;
		try {
			result = setParameter(sql, params).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 处理拼接字符串的查询的sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @return 返回ResultSet结果集
	 */
	public ResultSet select(String sql) {
		ResultSet rs = null;
		try {
			rs = getPreparedStatement(sql).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 处理含占位符的增加、删改、更新的sql语句
	 * 
	 * @param sql
	 *            含占位符的sql语句
	 * @param params
	 *            含参数的Object数组
	 * @return 返回Integer
	 */
	public Integer cud(String sql, Object[] params) {
		Integer count = 0;
		try {
			count = setParameter(sql, params).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 处理拼接字符串的增加、删改、更新的sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @return 返回Integer
	 */
	public Integer cud(String sql) {
		Integer count = 0;
		try {
			count = getPreparedStatement(sql).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
