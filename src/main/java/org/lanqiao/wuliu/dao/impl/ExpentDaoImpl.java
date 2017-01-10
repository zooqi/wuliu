/**
 * 
 */
package org.lanqiao.wuliu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Expent;
import org.lanqiao.wuliu.util.DBUtils;

/**
 * 财务管理
 * 
 * @author 杨明静
 *
 */
public class ExpentDaoImpl extends BaseDaoImpl {

	/**
	 * 添加支出
	 * 
	 * @param emp
	 * @return
	 */
	public int expInsert(Expent expent) {
		String sql = "INSERT expent(expEmpNum,expEmpName,expFunction,expMoney,expDate,expRemark) VALUES(?,?,?,?,?,?)";
		Object[] params = new Object[] { expent.getExpEmpNum(), expent.getExpEmpName(), expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(), expent.getExpRemark() };
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
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
			DBUtils.closeResultSet(resultSet);
		}
		return count;
	}

	/**
	 * 删除信息
	 * 
	 * @param expId
	 *            支出Id
	 * @return 返回删除记录数
	 */
	public int expDelete(int expId) {
		String sql = "DELETE FROM expent WHERE expId=?";
		Object[] params = new Object[] { expId };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
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
			DBUtils.closeResultSet(resultSet);
		}
		return count;
	}

	/**
	 * 更新信息
	 * 
	 * @param expId
	 *            支出Id
	 * @return 返回更新记录数
	 */
	public int expUpdate(Expent expent, int expId) {
		String sql = "UPDATE expent SET expEmpNum=?,expEmpName=?,expFunction=?,expMoney=?,expDate=?,expRemark=? WHERE expId=?";
		Object[] params = new Object[] { expent.getExpEmpNum(), expent.getExpEmpName(), expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(), expent.getExpRemark(), expId };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = DBUtils.getConnection();

			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(resultSet);
		}
		return count;
	}

	/**
	 * 查找信息
	 * 
	 * @param pageCurrentFirst
	 *            第一条记录
	 * @param pageRows
	 *            一页记录数
	 * @param expentReach
	 * @return 返回一个ArrayList集合
	 */
	public ArrayList<Expent> expSelect(int pageCurrentFirst, int pageRows, Expent expReach, String expDate) {
		ArrayList<Expent> list = new ArrayList<Expent>();

		StringBuffer sql = new StringBuffer(
				"SELECT expEmpNum,expEmpName,expFunction,expMoney,expDate,expRemark,expId FROM expent WHERE 1=1 ");
		if (expReach.getExpEmpNum() != null && !expReach.getExpEmpNum().equals("")) {
			sql.append("AND expEmpNum like '%").append(expReach.getExpEmpNum()).append("%' ");
		}
		if (expReach.getExpEmpName() != null && !expReach.getExpEmpName().equals("")) {
			sql.append("AND expEmpName like '%").append(expReach.getExpEmpName()).append("%' ");
		}
		if (expReach.getExpFunction() != null && !expReach.getExpFunction().equals("")) {
			sql.append("AND expFunction like '%").append(expReach.getExpFunction()).append("%' ");
		}
		if (expDate != null && !expDate.equals("")) {
			sql.append("AND expDate like '%").append(expDate).append("%' ");
		}
		sql.append(" ORDER BY expId LIMIT ?, ?");
		// ResultSet rs = select(sql.toString(), new Object[] {
		// pageCurrentFirst, pageRows });
		Object[] params = new Object[] { pageCurrentFirst, pageRows };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			setParameter(preparedStatement, sql.toString(), params);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Expent expent = new Expent();
				expent.setExpEmpNum(rs.getString(1));
				expent.setExpEmpName(rs.getString(2));
				expent.setExpFunction(rs.getString(3));
				expent.setExpMoney(rs.getDouble(4));
				expent.setExpDate(rs.getDate(5));
				expent.setExpRemark(rs.getString(6));
				expent.setExpId(rs.getInt(7));
				list.add(expent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}

	/**
	 * 统计支出表的记录数
	 * 
	 * @return 返回总记录数
	 */
	public int expCount() {
		String sql = "SELECT COUNT(expId) FROM expent";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			return 0;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(resultSet);
		}
		return count;
	}

	/**
	 * 发货收支查询(根据某个时间某辆车)
	 * 
	 * @param log
	 *            logistics表
	 * @return 返回一个ArrayList集合
	 */
	public ArrayList<Object[]> getIncome1(int currentPage, int rowsPerPage, String logSendDate, String logCarLicence) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		StringBuffer sql = new StringBuffer(
				"SELECT logSendDate,logCarLicence,SUM(goPay),SUM(goDamagePay),SUM(goCommission),l.logId,SUM(logCarPay),SUM(goInsurancePay),SUM(logUnloadPay) FROM goods g,logistics l WHERE g.logId=l.logId AND goType=0 AND logType=0 ");
		if (logSendDate != null && !logSendDate.equals("")) {
			sql.append("AND logSendDate like '%").append(logSendDate).append("%' ");
		}
		if (logCarLicence != null && !logCarLicence.equals("")) {
			sql.append("AND logCarLicence like '%").append(logCarLicence).append("%' ");
		}
		sql.append(" GROUP BY logSendDate,logCarLicence LIMIT ?, ?");
		// ResultSet rs = select(sql.toString(), new Object[] { currentPage,
		// rowsPerPage });
		Object[] params = new Object[] { currentPage, rowsPerPage };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			setParameter(preparedStatement, sql.toString(), params);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Object[] object = new Object[9];
				object[0] = rs.getDate(1);
				object[1] = rs.getString(2);
				object[2] = rs.getDouble(3);
				object[3] = rs.getDouble(4);
				object[4] = rs.getDouble(5);
				object[5] = rs.getInt(6);
				object[6] = rs.getDouble(7);
				object[7] = rs.getDouble(8);
				object[8] = rs.getDouble(9);
				list.add(object);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}

	/**
	 * 到货收支查询(根据某个时间某辆车)
	 * 
	 * @param log
	 *            logistics表
	 * @return 返回一个ArrayList集合
	 */
	public ArrayList<Object[]> getIncome2(int pageCurrentFirst, int pageRows, String logSendDate,
			String logCarLicence) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		StringBuffer sql = new StringBuffer(
				"SELECT logSendDate,logCarLicence,SUM(goTransitPay),SUM(goDamagePay),l.logId,SUM(logUnloadPay) FROM goods g,logistics l WHERE g.logId=l.logId AND logType=1 AND goType=1 ");
		if (logSendDate != null && !logSendDate.equals("")) {
			sql.append("AND logSendDate like '%").append(logSendDate).append("%' ");
		}
		if (logCarLicence != null && !logCarLicence.equals("")) {
			sql.append("AND logCarLicence like '%").append(logCarLicence).append("%' ");
		}
		sql.append(" GROUP BY logSendDate,logCarLicence LIMIT ?, ?");
		// ResultSet rs = select(sql.toString(), new Object[] {
		// pageCurrentFirst, pageRows });

		Object[] params = new Object[] { pageCurrentFirst, pageRows };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			setParameter(preparedStatement, sql.toString(), params);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Object[] object = new Object[6];
				object[0] = rs.getDate(1);
				object[1] = rs.getString(2);
				object[2] = rs.getDouble(3);
				object[3] = rs.getDouble(4);
				object[4] = rs.getInt(5);
				object[5] = rs.getDouble(6);
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}

	/**
	 * 发货收支查询(根据某个月份)
	 * 
	 * @param log
	 *            logistics表
	 * @return 返回一个ArrayList集合
	 */
	public ArrayList<Object[]> getIncome1Date(int pageCurrentFirst, int pageRows, String date) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();

		String sql = "SELECT  date_format(logSendDate,'%Y-%m') AS a,SUM(goPay),SUM(goDamagePay),SUM(goCommission),SUM(logCarPay),SUM(goInsurancePay),SUM(logUnloadPay) FROM goods g,logistics l WHERE g.logId=l.logId AND goType=0 AND logType=0 AND logSendDate LIKE ? GROUP BY a LIMIT ?, ?";

		// ResultSet rs = select(sql, new Object[] { "%" + date + "%",
		// pageCurrentFirst, pageRows });
		Object[] params = new Object[] { "%" + date + "%", pageCurrentFirst, pageRows };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Object[] object = new Object[7];
				object[0] = rs.getString(1);
				object[1] = rs.getDouble(2);
				object[2] = rs.getDouble(3);
				object[3] = rs.getDouble(4);
				object[4] = rs.getDouble(5);
				object[5] = rs.getDouble(6);
				object[6] = rs.getDouble(7);
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}

	/**
	 * 到货收支查询(根据某个月份)
	 * 
	 * @param log
	 *            logistics表
	 * @return 返回一个ArrayList集合
	 */
	public ArrayList<Object[]> getIncome2Date(int pageCurrentFirst, int pageRows, String date) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		String sql = "SELECT  date_format(logSendDate,'%Y-%m') AS a,SUM(goTransitPay),SUM(goDamagePay),SUM(logUnloadPay) FROM goods g,logistics l WHERE g.logId=l.logId AND goPayWay='到付' AND goType=1 AND logType=1 AND logSendDate LIKE ? GROUP BY a LIMIT ?,?";
		// ResultSet rs = select(sql, new Object[] { "%" + date + "%",
		// pageCurrentFirst, pageRows, });
		Object[] params = new Object[] { "%" + date + "%", pageCurrentFirst, pageRows };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Object[] object = new Object[4];
				object[0] = rs.getString(1);
				object[1] = rs.getDouble(2);
				object[2] = rs.getDouble(3);
				object[3] = rs.getDouble(4);
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}

	/**
	 * 计算总的日常支出
	 * 
	 * @param date
	 *            日常支出时间
	 * @return ArrayList
	 */
	public ArrayList<Object[]> getMoney(int pageCurrentFirst, int pageRows, String date) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		String sql = "SELECT SUM(expMoney),date_format(expDate,'%Y-%m') AS a,expId FROM expent WHERE expDate LIKE ? GROUP BY a LIMIT ?,?";

		// ResultSet rs = select(sql, new Object[] { "%" + date + "%",
		// pageCurrentFirst, pageRows });
		Object[] params = new Object[] { "%" + date + "%", pageCurrentFirst, pageRows };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Object[] object = new Object[3];
				object[0] = rs.getDouble(1);
				object[1] = rs.getString(2);
				object[2] = rs.getInt(3);
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}

	/**
	 * 每月支付员工的金钱情况
	 * 
	 * @param pageCurrentFirst
	 *            第一条记录
	 * @param pageRows
	 *            页数
	 * @param date
	 *            时间
	 * @return ArrayList
	 */
	public ArrayList<Object[]> getAttent(int pageCurrentFirst, int pageRows, String date) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		String sql = "SELECT attentDate,SUM(attentOverTimePay),SUM(attentBonus),SUM(empWage) FROM attent WHERE attentDate LIKE ? GROUP BY attentDate LIMIT ?,?";
		// ResultSet rs = select(sql, new Object[] { "%" + date + "%",
		// pageCurrentFirst, pageRows });
		Object[] params = new Object[] { "%" + date + "%", pageCurrentFirst, pageRows };
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, params);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Object[] object = new Object[4];
				object[0] = rs.getString(1);
				object[1] = rs.getDouble(2);
				object[2] = rs.getDouble(3);
				object[3] = rs.getDouble(4);
				list.add(object);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}

	/**
	 * 得到支出表，物流表的时间的并集
	 * 
	 * @return 返回ArrayList<Object[]>
	 */
	public ArrayList<String> getDate() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT date_format(expDate,'%Y-%m') FROM expent UNION SELECT date_format(logSendDate,'%Y-%m') FROM logistics UNION SELECT attentDate FROM attent";
		// ResultSet rs = select(sql);
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String date = rs.getString(1);
				list.add(date);
			}
		} catch (SQLException e) {
			return list;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closeStatement(statement);
			DBUtils.closeResultSet(rs);
		}
		return list;
	}
}
