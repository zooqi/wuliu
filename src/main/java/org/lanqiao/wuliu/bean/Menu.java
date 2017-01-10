package org.lanqiao.wuliu.bean;

import java.util.List;

/**
 * 菜单表
 * 
 * @author 杨明静
 *
 */
public class Menu {

	private Integer menuId;
	private String menuName;
	private List<Fun> funList;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public List<Fun> getFunList() {
		return funList;
	}

	public void setFunList(List<Fun> funList) {
		this.funList = funList;
	}

	@Override
	public int hashCode() {
		return menuId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Menu)) {
			return false;
		}

		Menu menu = (Menu) obj;
		if (getMenuId().equals(menu.getMenuId()) && getMenuName().equals(menu.getMenuName())) {
			return true;
		}
		return false;
	}

}
