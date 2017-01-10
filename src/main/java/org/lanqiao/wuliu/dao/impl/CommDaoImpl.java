package org.lanqiao.wuliu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.lanqiao.wuliu.bean.Fun;
import org.lanqiao.wuliu.bean.Menu;
import org.lanqiao.wuliu.util.DBUtils;

/**
 * 角色通有的DAO层
 * 
 * @author 杨明静
 *
 */
public class CommDaoImpl extends BaseDaoImpl {

	/**
	 * 登录(返回-2代表无此用户, 返回-1代表密码错误, 返回正数代表登录成功, 此整数即为empId)
	 * 
	 * @param empNum
	 * @param empPasswd
	 * @return
	 */
	public int login(String empNum, String empPasswd) {
		String sql = "SELECT empId, empPasswd FROM emp WHERE empNum = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, new Object[] { empNum });
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String dbPasswd = resultSet.getString(2);
				if (dbPasswd.equals(empPasswd)) {
					return resultSet.getInt(1);
				} else {
					return -1;
				}
			} else {
				return -2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(resultSet);
		}
	}

	/**
	 * 获取目录树
	 * 
	 * @param empId
	 * @return
	 */
	public Set<Menu> getMenus(int empId) {
		String sql = "SELECT f.*, m.menuName FROM fun f, emp_fun ef, menu m WHERE f.funId = ef.funId AND f.menuId = m.menuId AND ef.empId = ?";
		List<Fun> funs = new LinkedList<Fun>();
		Set<Menu> menus = Collections.synchronizedSet(new HashSet<Menu>());// 合并后的Menu集合
		Set<Menu> finalMenus = Collections.synchronizedSet(new HashSet<Menu>());// 生成目录树后的Menu集合

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, sql, new Object[] { empId });
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Fun fun = new Fun();
				fun.setFunId(resultSet.getInt(1));
				fun.setFunURI(resultSet.getString(2));
				fun.setFunName(resultSet.getString(3));
				fun.setMenuId(resultSet.getInt(4));
				funs.add(fun);

				Menu menu = new Menu();
				menu.setMenuId(resultSet.getInt(4));
				menu.setMenuName(resultSet.getString(5));
				menus.add(menu);
			}

			for (Menu menu : menus) {
				List<Fun> menuFuns = new LinkedList<Fun>();
				for (Fun fun : funs) {
					if (menu.getMenuId().equals(fun.getMenuId())) {
						menuFuns.add(fun);
					}
				}
				menu.setFunList(menuFuns);
				finalMenus.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return finalMenus;
		} finally {
			DBUtils.closeConnection(connection);
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeResultSet(resultSet);
		}
		return finalMenus;
	}

}
