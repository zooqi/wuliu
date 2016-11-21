package org.lanqiao.wuliu.service.impl;

import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Attent;
import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.dao.impl.HRManageDao;

public class HRManageServiceImpl {
	HRManageDao hsi = new HRManageDao();

	/**
	 * 添加员工信息
	 * 
	 * @param emp
	 *            Emp对象
	 * @return 返回int
	 */
	public int empInforInser(Emp emp) {
		return hsi.empInforInser(emp);
	}

	/**
	 * 统计emp表的记录数
	 * 
	 * @return 返回int型
	 */
	public int empCount() {
		return hsi.empCount();
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
		return hsi.empInforSel(pageCurrentFirst, pageRows, empReach);
	}

	/*
	 * public int empPasswdUpda(String empPasswd,String empId){ return
	 * hsi.empPasswdUpda(empPasswd, empId); }
	 */
	/**
	 * 更新员工信息
	 * 
	 * @param emp
	 *            员工对象
	 * @param empNum
	 *            员工号
	 */
	public int empInforUpda(Emp emp, int empId) {
		return hsi.empInforUpda(emp, empId);
	}

	/**
	 * 删除员工信息
	 * 
	 * @param empId
	 * @return
	 */
	public int empInforDele(int empId) {
		return hsi.empInforDele(empId);
	}

	/**
	 * 查找员工Id和姓名
	 * 
	 * @return 返回ArrayList数组
	 */
	public ArrayList<Emp> empInfor() {
		return hsi.empInfor();
	}

	/**
	 * 记录每月员工考勤
	 * 
	 * @param attent
	 *            Attent对象
	 */
	public int attentInsert(Attent attent, int empId) {
		return hsi.attentInsert(attent, empId);
	}

	/**
	 * 统计考勤记录数
	 * 
	 * @return 返回int
	 */
	public int attentCount() {
		return hsi.attentCount();
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
			Attent attentReach,String attentDate) {
		return hsi.attentSel(pageCurrentFirst, pageRows, attentReach,attentDate);
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
		return hsi.attentUpda(attent, attentId);
	}

	/**
	 * 删除员工考勤记录
	 * 
	 * @param attentId
	 *            考勤Id
	 * @return 返回int
	 */
	public int attentDele(int attentId) {
		return hsi.attentDele(attentId);
	}
}
