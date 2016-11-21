/**
 * 
 */
package org.lanqiao.wuliu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.bean.Expent;

/**
 * 支出
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
		String sql = "INSERT expent(expFunction,expMoney,expDate,expRemak,empId) VALUES(?,?,?,?,?)";
		Object[] params = new Object[] { expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(),
				expent.getExpRemark(), expent.getEmp().getEmpId() };
		return cud(sql, params);
	}

	public int expDelete(int expId) {
		String sql = "DELETE　FROM expent WHERE expId=?";
		Object[] params = new Object[] { expId };
		return cud(sql, params);
	}

	public int expUpdate(int expId, int empId) {
		Expent expent = new Expent();
		String sql = "UPDATE expent ex,emp e SET expFunction=?,expMoney=?,expDate=?,expRemak=?,empName=? WHERE ex.empId=e.empId AND expId=? AND empId=?";
		Object[] params = new Object[] { expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(),
				expent.getExpRemark(), expent.getEmp().getEmpId(),
				expent.getEmp().getEmpName(), expent.getEmp().getEmpNum() };
		return cud(sql, params);
	}

	public ArrayList<Expent> expSelect(int pageCurrentFirst, int pageRows,
			Expent expentReach) {
		ArrayList<Expent> list = new ArrayList<Expent>();
		
		StringBuffer sql = new StringBuffer(
				"SELECT empNum,empName,empDepart,expFunction,expMoney,expDate,expRemak FROM emp e,expent ex WHERE e.empId=ex.empId AND empId=? AND expId=?");
		if (expentReach.getExpFunction() != null
				&& !expentReach.getExpFunction().equals("")) {
			sql.append("AND expentFuncton like '%")
					.append(expentReach.getExpFunction()).append("%' ");
		}
		if (expentReach.getExpDate() != null
				&& !expentReach.getExpDate().equals("")) {
			sql.append("AND expentDate like '%")
					.append(expentReach.getExpDate()).append("%' ");
		}
		if (expentReach.getEmp().getEmpName() != null
				&& !expentReach.getEmp().getEmpName().equals("")) {
			sql.append("AND empName like '%")
					.append(expentReach.getEmp().getEmpName()).append("%' ");
		}
		if (expentReach.getEmp().getEmpNum() != null
				&& !expentReach.getEmp().getEmpNum().equals("")) {
			sql.append("AND empNum like '%")
					.append(expentReach.getEmp().getEmpNum()).append("%' ");
		}
		if (expentReach.getEmp().getEmpDepart() != null
				&& !expentReach.getEmp().getEmpDepart().equals("")) {
			sql.append("AND empDepart like '%")
					.append(expentReach.getEmp().getEmpDepart()).append("%' ");
		}
		sql.append(" ORDER BY ex.expId LIMIT ?, ?");
		ResultSet rs = select(sql.toString(), new Object[] { pageCurrentFirst,
				pageRows });
		try {
			while(rs.next()){
				Emp emp=new Emp();
				Expent expent=new Expent();
				emp.setEmpNum(rs.getString(1));
				emp.setEmpDepart(rs.getString(2));
				emp.setEmpDepart(rs.getString(3));
				expent.setExpFunction(rs.getString(4));
				expent.setExpMoney(rs.getDouble(5));
				expent.setExpDate(rs.getDate(6));
				expent.setExpRemark(rs.getString(7));
				expent.setEmp(emp);
				list.add(expent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
