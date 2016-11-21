package org.lanqiao.wuliu.dao;

import java.sql.ResultSet;
/**
 * 基本CRUD接口
 * @author 杨明静
 *
 */
public interface IBaseDao {
	/**
	 * 处理含占位符的查询的sql接口
	 * @param sql 含占位符的查询的sql语句
	 * @param params 参数数组
	 * @return  返回ResultSet结果集
	 */
	public ResultSet select(String sql,Object[] params);
	
	/**
	 * 处理拼接字符串的查询的sql的接口
	 * @param sql sql语句
	 * @return 返回ResultSet结果集
	 */
	public ResultSet select(String sql);
	
	/**
	 * 处理含占位符的增加、删改、更新的sql语句的接口
	 * @param sql 含占位符的sql语句
	 * @param params 含参数的Object数组
	 * @return 返回Integer
	 */
	public Integer cud(String sql,Object[] params);
	
	/**
	 * 处理拼接字符串的增加、删改、更新的sql语句的接口
	 * @param sql sql语句
	 * @return 返回Integer
	 */
	public Integer cud(String sql);
}
