package org.lanqiao.wuliu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.lanqiao.wuliu.util.DBUtils;

/**
 * 权限管理的数据库层
 * 
 * @author 杨明静
 *
 */
public class JurisdictionDaoImpl extends BaseDaoImpl {
	/**
	 * 根据empId查找funId及funName
	 * 
	 * @param empId
	 * @return 返回ArrayList<Object[]>
	 */
	public ArrayList<Object[]> getFun(int empId) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		String sql = "SELECT empId=?,f.funId,funName FROM fun f LEFT JOIN emp_fun ef ON f.funId=ef.funId";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			Object[] params = new Object[] { empId };
			setParameter(preparedStatement, sql, params);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Object[] object = new Object[3];
				object[0] = resultSet.getInt(1);
				object[1] = resultSet.getInt(2);
				object[2] = resultSet.getString(3);
				list.add(object);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(resultSet);
		}
		return list;
	}

	/**
	 * 插入权限信息
	 * 
	 * @param empId
	 *            职工Id
	 * @param funId
	 *            功能Id
	 * @return 返回更新成功的记录数
	 */
	public int updateJur(int empId, int funId) {
		String sql = "INSERT INTO emp_fun(empId, funId) VALUES (?,?)";
		Object[] params = new Object[] { empId, funId };
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			return 0;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
		}
		return count;
	}

	/**
	 * 根据empId查找funId
	 * 
	 * @param empId
	 *            empId
	 * @return ArrayList
	 */
	public ArrayList<Integer> getFuns(int empId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "SELECT f.funId FROM fun f LEFT JOIN emp_fun ef ON f.funId=ef.funId WHERE empId=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			Object[] params = new Object[] { empId };
			setParameter(preparedStatement, sql, params);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int a = resultSet.getInt(1);
				list.add(a);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(resultSet);
		}
		return list;
	}

	/**
	 * 删除权限
	 * 
	 * @param empId
	 *            empId
	 * @param funId
	 *            funId
	 * @return 返回删除的记录数
	 */
	public int deleJur(int empId, int funId) {
		String sql = "DELETE FROM emp_fun WHERE empId=? AND funId=?";
		Object[] params = new Object[] { empId, funId };
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			return 0;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
		}
		return count;
	}
}
