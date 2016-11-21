package org.lanqiao.wuliu.service.impl;

import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.bean.Fun;
import org.lanqiao.wuliu.bean.Menu;
import org.lanqiao.wuliu.bean.Role;
import org.lanqiao.wuliu.dao.impl.CommDaoImpl;

/**
 * 角色通有的业务逻辑层
 * 
 * @author 杨明静
 *
 */
public class CommServiceImpl {
	CommDaoImpl cdi = new CommDaoImpl();

	/**
	 * 登录
	 * 
	 * @param emp
	 *            员工对象
	 * @return 返回代表登录状态的int
	 */
	public int login(Emp emp) {
		Emp compare = cdi.login(emp);
		if (compare.getEmpNum() != null) {
			if (compare.getEmpPasswd().equals(emp.getEmpPasswd())) {
				// 登录成功
				return 0;
			} else {
				// 密码错误
				return 1;
			}
		}
		// 职工号不存在
		return 2;
	}
	public Emp getEmpId(Emp emp1){
		return cdi.login(emp1);
	}
	public ArrayList<Role> getRoleId(String empNum) {
		return cdi.getRoleId(empNum);
	}
	
/*
	public ArrayList<Menu> getMenuId(int roleId){
		return cdi.getMenuId(roleId);
	}
	
	public ArrayList<Menu> getTwoMenuId(int menuId){
		return cdi.getTwoMenuId(menuId);
	}
	
	public ArrayList<Fun> getFunURI(int twoMenuId){
		return cdi.getFunURI(twoMenuId);
	}
*/	
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	public ArrayList<Menu> getMenus(Integer roleId) {
		return cdi.getMenus(roleId);
	}
}
