package org.lanqiao.wuliu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Emp;

/**
 * 权限管理的数据库层
 * 
 * @author 杨明静
 *
 */
public class Jurisdiction extends BaseDaoImpl {
	/**
	 * 更新权限信息
	 * 
	 * @param empId
	 *            职工Id
	 * @param funId
	 *            功能Id
	 * @return 返回更新成功的记录数
	 */
	public int updateJur(int empId, int funId) {
		String sql = "UPDATE emp_funId  SET funId=? WHERE empId=?";
		Object[] params = new Object[] { empId, funId };
		return cud(sql, params);
	}
	
	/**
	 * 查找权限信息
	 * 
	 * @param empReach
	 *            职工表
	 * @return 返回一个ArrayList对象数组
	 */
	public ArrayList<Object[]> selectJur(Emp empReach) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		StringBuffer sql = new StringBuffer(
				"SELECT m.menuId,menuName,funId,funName FROM fun f RIGHT JOIN menu m ON f.menuId=m.menuId ");
		if (empReach.getEmpId() != null && !empReach.getEmpId().equals("")) {
			sql.append("AND expEmpId like '%").append(empReach.getEmpId())
					.append("%' ");
		}
		if (empReach.getEmpNum() != null && !empReach.getEmpNum().equals("")) {
			sql.append("AND expEmpNum like '%").append(empReach.getEmpNum())
					.append("%' ");
		}
		if (empReach.getEmpName() != null && !empReach.getEmpName().equals("")) {
			sql.append("AND empName like '%").append(empReach.getEmpName())
					.append("%' ");
		}
		if (empReach.getEmpDepart() != null
				&& !empReach.getEmpDepart().equals("")) {
			sql.append("AND empDepart like '%")
					.append(empReach.getEmpDepart()).append("%' ");
		}
		ResultSet rs = select(sql.toString(), new Object[] { empReach });
		try {
			while (rs.next()) {
				Object[] object = new Object[4];
				object[0] = rs.getInt(1);
				object[1] = rs.getString(2);
				object[2] = rs.getInt(3);
				object[3] = rs.getString(4);
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
