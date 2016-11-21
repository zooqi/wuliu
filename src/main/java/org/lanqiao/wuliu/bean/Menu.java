package org.lanqiao.wuliu.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单表
 * 
 * @author 杨明静
 *
 */
public class Menu {
	private Integer menuId;
	private Integer menuFather;
	private String menuName;
	private List<Menu> childMenu = new ArrayList<Menu>();
	private List<Fun> fun = new ArrayList<Fun>();

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuFather() {
		return menuFather;
	}

	public void setMenuFather(Integer menuFather) {
		this.menuFather = menuFather;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}

	public List<Fun> getFun() {
		return fun;
	}

	public void setFun(List<Fun> fun) {
		this.fun = fun;
	}

}
