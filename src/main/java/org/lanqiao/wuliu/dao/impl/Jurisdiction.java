package org.lanqiao.wuliu.dao.impl;

/**
 * 权限管理的数据库层
 * 
 * @author 杨明静
 *
 */
public class Jurisdiction {
	String sql="UPDATE role,menu,fun SET roleName=?,menuName=?,funName=? WHERE S";
}
