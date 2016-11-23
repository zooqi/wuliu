package org.lanqiao.wuliu.util;

import java.sql.Connection;
import java.sql.DriverManager;
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
		} catch (Exception e  ) {
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
	 * 关闭Connection对象所持有的数据库连接
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(Connection connection) throws SQLException {
		if (connection == null || connection.isClosed()) {
			return;
		}

		try {
			connection.close();
		} catch (SQLException e) {
			throw new SQLException("关闭数据库连接失败!");
		}
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
