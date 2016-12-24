package org.lanqiao.wuliu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.util.DBUtils;

public class TrafficDaoImpl extends BaseDaoImpl {

	/**
	 * 获取车流列表
	 * 
	 * @param currentPage
	 * @param rowsPerPage
	 * @return
	 */
	public List<Logistics> trafficReach(int currentPage, int rowsPerPage) {
		List<Logistics> list = new LinkedList<Logistics>();

		String sql = "SELECT * FROM logistics ORDER BY logSendDate LIMIT ?, ?";
		Object[] params = new Object[] { DBUtils.getOffset(currentPage, rowsPerPage), rowsPerPage };

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Logistics logistics = new Logistics();
				logistics.setLogId(resultSet.getInt(1));
				logistics.setLogContractNum(resultSet.getString(2));
				logistics.setLogSendDate(resultSet.getDate(3));
				logistics.setLogSiteStart(resultSet.getString(4));
				logistics.setLogSiteEnd(resultSet.getString(5));
				logistics.setLogCarLicence(resultSet.getString(6));
				logistics.setLogCarDriver(resultSet.getString(7));
				logistics.setLogCarPhone(resultSet.getString(8));
				logistics.setLogCarPay(resultSet.getDouble(9));
				logistics.setLogPartner(resultSet.getString(10));
				logistics.setLogType(resultSet.getInt(11));
				list.add(logistics);
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
	 * 获取可用的发车列表
	 * 
	 * @return
	 */
	public List<Object[]> availableDepart() {
		List<Object[]> list = new LinkedList<Object[]>();
		String sql = "SELECT logId, logContractNum, logSendDate, logSiteStart, logSiteEnd, logCarLicence, logCarDriver FROM logistics WHERE logType = 0 AND logSendDate >= CURRENT_DATE ORDER BY logSendDate";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Object[] objects = new Object[7];
				objects[0] = resultSet.getInt(1);
				objects[1] = resultSet.getString(2);
				objects[2] = resultSet.getDate(3);
				objects[3] = resultSet.getString(4);
				objects[4] = resultSet.getString(5);
				objects[5] = resultSet.getString(6);
				objects[6] = resultSet.getString(7);
				list.add(objects);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closeStatement(statement);
			DBUtils.closeResultSet(resultSet);
		}
		return list;
	}

	/**
	 * 获取车流总数
	 * 
	 * @return
	 */
	public int trafficCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM logistics";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			return 0;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closeStatement(statement);
			DBUtils.closeResultSet(resultSet);
		}
		return count;
	}
}
