package org.lanqiao.wuliu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.bean.Fun;
import org.lanqiao.wuliu.bean.Menu;
import org.lanqiao.wuliu.bean.Role;

/**
 * 角色通有的DAO层
 * 
 * @author 杨明静
 *
 */
public class CommDaoImpl extends BaseDaoImpl {
	/**
	 * 查询职工号和密码
	 * 
	 * @param emp1
	 *            Emp对象
	 * @return 返回Emp对象
	 */
	public Emp login(Emp emp1) {
		String sql = "SELECT empId,empNum,empPasswd FROM emp WHERE empNum=?";
		ResultSet rs = select(sql, new Object[] { emp1.getEmpNum() });
		Emp emp = new Emp();
		try {
			if (rs.next()) {
				Integer empId = rs.getInt(1);
				String empNum = rs.getString(2);
				String empPasswd = rs.getString(3);
				emp.setEmpId(empId);
				emp.setEmpNum(empNum);
				emp.setEmpPasswd(empPasswd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	/**
	 * 获得roleId
	 * 
	 * @param empNum
	 *            职工的empNum
	 * @return 返回一个对象集合
	 */
	public ArrayList<Role> getRoleId(String empNum) {
		String sql = "SELECT r.roleId, r.roleName FROM role r, emp_role er WHERE r.roleId = er.roleId AND er.empId = (select empId from emp where empNum = '"
				+ empNum + "')";
		ResultSet rs = select(sql);
		ArrayList<Role> arrayList = new ArrayList<Role>();
		try {
			while (rs.next()) {
				Role role = new Role();
				role.setRoleId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				arrayList.add(role);
				System.out.println("角色：" + rs.getString("roleName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	/**
	 * 得到主菜单
	 * 
	 * @param roleId
	 *            角色Id
	 * @return 返回一个ArrayList集合
	 */
	public ArrayList<Menu> getMenus(Integer roleId) {

		ArrayList<Menu> ar = new ArrayList<Menu>();

		// 这里查询所有的主菜单
		String sql = "SELECT m.menuId, m.menuName FROM menu m, role_menu rm WHERE m.menuId = rm.menuId AND rm.roleId = "
				+ roleId;

		// 如果上述情况不成立
		// String sql =
		// "SELECT m.menuId, m.menuName FROM menu m, role_menu rm WHERE m.menuId = rm.menuId AND m.menuFather = null AND rm.roleId = "
		// + roleId;

		ResultSet rs = select(sql);
		try {
			while (rs.next()) {
				Integer menuId = rs.getInt(1);
				System.out.println("一级菜单：" + rs.getString("menuName"));
				List<Menu> subMenus = new ArrayList<Menu>();
				// 这里查询上面主菜单对应的子菜单，查他的功能列表
				sql = "SELECT menuId, menuName FROM menu WHERE menuFather = "
						+ menuId;
				ResultSet subRs = select(sql);
				while (subRs.next()) {
					Integer subMenuId = subRs.getInt(1);
					System.out.println("\t二级菜单：" + subRs.getString("menuName"));
					List<Fun> funs = new ArrayList<Fun>();
					sql = "SELECT f.funId, f.funURI, f.funName FROM fun f,menu m WHERE f.menuId = m.menuId AND m.menuId = "
							+ subMenuId;
					ResultSet funRs = select(sql);
					while (funRs.next()) {
						Fun fun = new Fun();
						System.out.println("\t\t功能列表："
								+ funRs.getString("funName"));
						fun.setFunId(funRs.getInt(1));
						fun.setFunURI(funRs.getString(2));
						fun.setFunName(funRs.getString(3));
						funs.add(fun);
					}
					Menu subMenu = new Menu();
					subMenu.setMenuId(subMenuId);
					subMenu.setMenuName(subRs.getString(2));
					subMenu.setFun(funs);
					subMenus.add(subMenu);
				}

				// 新建一个arraylist存放功能列表
				List<Fun> funs = new ArrayList<Fun>();
				sql = "SELECT f.funId, f.funURI, f.funName FROM fun f, menu m WHERE  m.menuId=f.menuId  AND m.menuId = "
						+ menuId;
				ResultSet mainFunRs = select(sql);
				while (mainFunRs.next()) {
					Fun fun = new Fun();
					System.out.println("\t\t功能列表："
							+ mainFunRs.getString("funName"));
					fun.setFunId(mainFunRs.getInt(1));
					fun.setFunURI(mainFunRs.getString(2));
					fun.setFunName(mainFunRs.getString(3));
					funs.add(fun);
				}

				Menu menu = new Menu();
				menu.setMenuId(menuId);
				menu.setMenuName(rs.getString(2));
				menu.setChildMenu(subMenus);
				menu.setFun(funs);
				ar.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}
}
