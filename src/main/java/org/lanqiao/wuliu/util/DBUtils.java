package org.lanqiao.wuliu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 * 
 * @author 杨明静
 *
 */
public class DBUtils {

	@Deprecated
	public static Connection connection = null;
	@Deprecated
	public static Statement statement = null;

	// new api
	private static final String URL = "jdbc:mysql://localhost:3306/baishun?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "1300730110.";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取一个新的Connection对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new SQLException("创建java.sql.Connection对象失败!");
		}
		return connection;
	}

	/**
	 * 关闭Connection对象, 并置为null
	 * 
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		if (connection == null) {
			return;
		}

		try {
			if (connection.isClosed()) {
				return;
			}
			connection.close();
			connection = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭Statement对象, 并置为null
	 * 
	 * @param statement
	 */
	public static void closeStatement(Statement statement) {
		if (statement == null) {
			return;
		}

		try {
			if (statement.isClosed()) {
				return;
			}
			statement.close();
			statement = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭PreparedStatement对象, 并置为null
	 * 
	 * @param preparedStatement
	 */
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement == null) {
			return;
		}

		try {
			if (preparedStatement.isClosed()) {
				return;
			}
			preparedStatement.close();
			preparedStatement = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭ResultSet对象, 并置为null
	 * 
	 * @param resultSet
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet == null) {
			return;
		}

		try {
			if (resultSet.isClosed()) {
				return;
			}
			resultSet.close();
			resultSet = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 计算偏移量
	 * 
	 * @param currentPage
	 *            当前页数
	 * @param rowsPerPage
	 *            页记录数
	 * @return
	 */
	public static int getOffset(int currentPage, int rowsPerPage) {
		return (currentPage - 1) * rowsPerPage;
	}

	@Deprecated
	public static void close(Connection conn, Statement sta) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (sta != null) {
				sta.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
