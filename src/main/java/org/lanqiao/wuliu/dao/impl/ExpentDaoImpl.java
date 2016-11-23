/**
 * 
 */
package org.lanqiao.wuliu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		String sql = "INSERT expent(expFunction,expMoney,expDate,expRemak) VALUES(?,?,?,?,?)";
		Object[] params = new Object[] { expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(),
				expent.getExpRemark()};
		return cud(sql, params);
	}

	public int expDelete(int expId) {
		String sql = "DELETE　FROM expent WHERE expId=?";
		Object[] params = new Object[] { expId };
		return cud(sql, params);
	}

	public int expUpdate(int expId) {
		Expent expent = new Expent();
		String sql = "UPDATE expent SET expFunction=?,expMoney=?,expDate=?,expRemak=? WHERE expId=?";
		Object[] params = new Object[] { expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(),
				expent.getExpRemark()};
		return cud(sql, params);
	}

	public ArrayList<Expent> expSelect(int pageCurrentFirst, int pageRows,
			Expent expentReach) {
		ArrayList<Expent> list = new ArrayList<Expent>();
		
		StringBuffer sql = new StringBuffer(
				"SELECT empNum,empName,expFunction,expMoney,expDate,expRemak FROM expent WHERE expId=?");
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
		if (expentReach.getExpEmpName()!= null
				&& !expentReach.getExpEmpName().equals("")) {
			sql.append("AND empName like '%")
					.append(expentReach.getExpEmpName()).append("%' ");
		}
		if (expentReach.getExpEmpNum() != null
				&& !expentReach.getExpEmpNum().equals("")) {
			sql.append("AND empNum like '%")
					.append(expentReach.getExpEmpNum()).append("%' ");
		}
		sql.append(" ORDER BY ex.expId LIMIT ?, ?");
		ResultSet rs = select(sql.toString(), new Object[] { pageCurrentFirst,
				pageRows });
		try {
			while(rs.next()){
			
				Expent expent=new Expent();
				expent.setExpEmpNum(rs.getString(1));
				expent.setExpEmpName(rs.getString(2));
				expent.setExpFunction(rs.getString(3));
				expent.setExpMoney(rs.getDouble(4));
				expent.setExpDate(rs.getDate(5));
				expent.setExpRemark(rs.getString(6));
				list.add(expent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
