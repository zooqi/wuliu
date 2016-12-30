package org.lanqiao.wuliu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Attent;
import org.lanqiao.wuliu.bean.Emp;

/**
 * 人事行政管理(CRUD)
 * 
 * @author 杨明静
 *
 */
public class HRManageDao extends BaseDaoImpl {
	/**
	 * 添加员工信息
	 * 
	 * @param emp
	 *            Emp员工对象
	 */
	public int empInforInser(Emp emp) {
		String sql = "INSERT INTO  emp(empNum,empName,empDepart,empPosition,empWage,empDate,empEdu,empSex,empBorn,empPhone,empQQ,empAddress,empHealth,empMarriage,empPasswd) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { emp.getEmpNum(), emp.getEmpName(),
				emp.getEmpDepart(), emp.getEmpPosition(), emp.getEmpWage(),
				emp.getEmpDate(), emp.getEmpEdu(), emp.getEmpSex(),
				emp.getEmpBorn(), emp.getEmpPhone(), emp.getEmpQQ(),
				emp.getEmpAddress(), emp.getEmpHealth(), emp.getEmpMarriage(),
				emp.getEmpPasswd() };
		return cud(sql, params);
	}

	/**
	 * 统计emp表的记录数
	 * 
	 * @return 返回int型
	 */
	public int empCount() {
		String sql = "SELECT COUNT(*) FROM emp";
		ResultSet resultSet = select(sql);
		try {
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * 查找员工信息
	 * 
	 * @param pageCurrentFirst
	 *            某页的第一条记录
	 * @param pageRows
	 *            一页的记录数
	 * @param empReach
	 *            Emp对象
	 * @return 返回ArrayList集合
	 */
	public ArrayList<Emp> empInforSel(int pageCurrentFirst, int pageRows,
			Emp empReach) {
		StringBuffer sql = new StringBuffer(
				"SELECT empNum,empName,empDepart,empPosition,empWage,empDate,empEdu,empSex,empBorn,empPhone,empQQ,empAddress,empHealth,empMarriage,empId,empRemark,empPasswd FROM emp WHERE 1 = 1 ");
		if (empReach.getEmpNum() != null && !empReach.getEmpNum().equals("")) {
			sql.append("AND empNum like '%").append(empReach.getEmpNum())
					.append("%' ");
		}
		if (empReach.getEmpName() != null && !empReach.getEmpName().equals("")) {
			sql.append("AND empName like '%").append(empReach.getEmpName())
					.append("%' ");
		}
		if (empReach.getEmpDepart() != null
				&& !empReach.getEmpDepart().equals("")) {
			sql.append("AND empDepart like '%").append(empReach.getEmpDepart())
					.append("%' ");
		}
		if (empReach.getEmpSex() != null && !empReach.getEmpSex().equals("")) {
			sql.append("AND empSex = '").append(empReach.getEmpSex())
					.append("' ");
		}
		sql.append("ORDER BY empId  LIMIT ?, ?");
		ArrayList<Emp> ar = new ArrayList<Emp>();
		ResultSet rs = select(sql.toString(), new Object[] { pageCurrentFirst,
				pageRows });
		try {
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpNum(rs.getString(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDepart(rs.getString(3));
				emp.setEmpPosition(rs.getString(4));
				emp.setEmpWage(rs.getDouble(5));
				emp.setEmpDate(rs.getDate(6));
				emp.setEmpEdu(rs.getString(7));
				emp.setEmpSex(rs.getString(8));
				emp.setEmpBorn(rs.getDate(9));
				emp.setEmpPhone(rs.getString(10));
				emp.setEmpQQ(rs.getString(11));
				emp.setEmpAddress(rs.getString(12));
				emp.setEmpHealth(rs.getString(13));
				emp.setEmpMarriage(rs.getString(14));
				emp.setEmpId(rs.getInt(15));
				emp.setEmpRemark(rs.getString(16));
				emp.setEmpPasswd(rs.getString(17));
				ar.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}

	/**
	 * 更新员工信息
	 * 
	 * @param emp
	 *            员工对象
	 * @param empNum
	 *            员工号
	 */
	public int empInforUpda(Emp emp, int empId) {
		String sql = "UPDATE emp SET empName=?,empDepart=?,empPosition=?,empWage=?,empDate=?,empEdu=?,empSex=?,empBorn=?,empPhone=?,empQQ=?,empAddress=?,empHealth=?,empMarriage=?,empPasswd=?,empRemark=? WHERE empId=?";
		Object[] params = new Object[] { emp.getEmpName(), emp.getEmpDepart(),
				emp.getEmpPosition(), emp.getEmpWage(), emp.getEmpDate(),
				emp.getEmpEdu(), emp.getEmpSex(), emp.getEmpBorn(),
				emp.getEmpPhone(), emp.getEmpQQ(), emp.getEmpAddress(),
				emp.getEmpHealth(), emp.getEmpMarriage(), emp.getEmpPasswd(),
				emp.getEmpRemark(), empId };
		return cud(sql, params);
	}

	/**
	 * 删除员工信息
	 * 
	 * @param empNum
	 *            员工Id
	 * @return 返回int
	 */
	public int empInforDele(int empId) {
		String sql = "DELETE FROM emp WHERE empId=?";
		return cud(sql, new Object[] { empId });
	}

	/**
	 * 查找员工信息(给其他功能使用)
	 * 
	 * @return 返回ArrayList数组
	 */
	public ArrayList<Emp> empInfor() {
		ArrayList<Emp> ar = new ArrayList<Emp>();
		String sql = "SELECT empId,empName,empDepart,empNum FROM emp ";
		ResultSet rs = select(sql);
		try {
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDepart(rs.getString(3));
				emp.setEmpNum(rs.getString(4));
				ar.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}

	/**
	 * 记录每月员工考勤
	 * 
	 * @param attent
	 *            Attent对象
	 */
	public int attentInsert(Attent attent, int empId) {
		String sql = "INSERT INTO attent(attentDate,attentNum,attentReasonNum,attentReason,attentOverTimeNum,attentOverTimePay,attentBonus,attentRemark,empId,empWage) VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { attent.getAttentDate(),
				attent.getAttentNum(), attent.getAttentReasonNum(),
				attent.getAttentReason(), attent.getAttentBonus(),
				attent.getAttentOverTimeNum(), attent.getAttentOverTimePay(),
				attent.getAttentRemark(), empId, attent.getEmpWage() };
		return cud(sql, params);
	}

	/**
	 * 统计考勤记录数
	 * 
	 * @return 返回int
	 */
	public int attentCount() {
		String sql = "SELECT COUNT(attentId) FROM attent";
		ResultSet rs = select(sql);
		int count = 0;
		try {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 查找员工出勤情况
	 * 
	 * @param pageCurrentFirst
	 *            某页的第一条记录
	 * @param pageRows
	 *            每页的记录数
	 * @param attentReach
	 *            attent对象
	 * @return 返回ArrayList集合
	 */
	public ArrayList<Attent> attentSel(int pageCurrentFirst, int pageRows,
			Attent attentReach, String attentDate) {
		StringBuffer sql = new StringBuffer(
				"SELECT e.empNum,e.empName,e.empDepart,a.attentDate,a.attentNum,a.attentReasonNum,a.attentReason,a.attentBonus,a.attentRemark,a.attentOverTimePay,a.attentOverTimeNum,e.empId,a.attentId,a.empWage FROM emp e ,attent a WHERE a.empId=e.empId ");
		if (attentReach.getEmp().getEmpNum() != null
				&& !attentReach.getEmp().getEmpNum().equals("")) {
			sql.append("AND e.empNum like '%")
					.append(attentReach.getEmp().getEmpNum()).append("%' ");
		}
		if (attentReach.getEmp().getEmpName() != null
				&& !attentReach.getEmp().getEmpName().equals("")) {
			sql.append("AND e.empName like '%")
					.append(attentReach.getEmp().getEmpName()).append("%' ");
		}
		if (attentDate != null && !attentDate.equals("")) {
			sql.append("AND a.attentDate like '%").append(attentDate)
					.append("%' ");
		}
		sql.append("ORDER BY e.empId  LIMIT ?, ?");
		ArrayList<Attent> ar = new ArrayList<Attent>();

		ResultSet rs = select(sql.toString(), new Object[] { pageCurrentFirst,
				pageRows });
		try {
			while (rs.next()) {
				Attent attent = new Attent();
				Emp emp = new Emp();
				emp.setEmpNum(rs.getString(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDepart(rs.getString(3));
				attent.setAttentDate(rs.getString(4));
				attent.setAttentNum(rs.getDouble(5));
				attent.setAttentReasonNum(rs.getDouble(6));
				attent.setAttentReason(rs.getString(7));
				attent.setAttentBonus(rs.getDouble(8));
				attent.setAttentRemark(rs.getString(9));
				attent.setAttentOverTimePay(rs.getDouble(10));
				attent.setAttentOverTimeNum(rs.getDouble(11));
				emp.setEmpId(rs.getInt(12));
				attent.setAttentId(rs.getInt(13));
				attent.setEmpWage(rs.getDouble(14));
				attent.setEmp(emp);
				ar.add(attent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}

	/**
	 * 更新员工考勤情况
	 * 
	 * @param attent
	 *            Attent对象
	 * @param attentId
	 *            考勤Id
	 * @return 返回int
	 */
	public int attentUpda(Attent attent, int attentId) {
		String sql = "UPDATE attent SET attentDate=?,attentNum=?,attentReasonNum=?,attentReason=?,attentOverTimeNum=?,attentBonus=?,attentRemark=?,attentOverTimePay=?,empWage=? WHERE "
				+ " attentId=?";
		Object[] params = new Object[] { attent.getAttentDate(),
				attent.getAttentNum(), attent.getAttentReasonNum(),
				attent.getAttentReason(), attent.getAttentOverTimeNum(),
				attent.getAttentBonus(), attent.getAttentRemark(),
				attent.getAttentOverTimePay(), attent.getEmpWage(),attentId };
		System.out.println(sql);
		return cud(sql, params);
	}

	/**
	 * 删除员工考勤记录
	 * 
	 * @param attentId
	 *            考勤Id
	 * @return 返回int
	 */
	public int attentDele(int attentId) {
		String sql = "DELETE FROM attent WHERE attentId=?";
		return cud(sql, new Object[] { attentId });
	}

}