package org.lanqiao.wuliu.service.impl;

import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.dao.impl.BusinessManage;

public class BusinessManageServiceImpl {

	BusinessManage bm = new BusinessManage();

	/**
	 * 添加货物信息
	 * 
	 * @param goods
	 *            货物对象
	 * @return 返回int
	 */
	public int goInsert(Goods goods) {
		return bm.goInsert(goods);
	}

	/**
	 * 添加物流信息
	 * 
	 * @param logistics
	 *            物流对象
	 * @return 插入的记录数
	 */
	public int loAdd(Logistics logistics) {
		return bm.loAdd(logistics);
	}

	/**
	 * 统计goods表的记录数
	 * 
	 * @return 返回int
	 */
	public int goConut() {
		return bm.goConut();
	}

	/**
	 * 更新物品清单数据
	 * 
	 * @param goods
	 *            物品清单对象
	 * @param goId
	 *            物品清单Id
	 * @return 返回int
	 */
	public int goUpda(Goods goods, int goId) {
		return bm.goUpda(goods, goId);
	}

	/**
	 * 查找物品清单信息
	 * 
	 * @param pageCurrentFirst
	 *            某页的第一条记录
	 * @param pageRows
	 *            一页的记录数
	 * @param goodsReach
	 *            物品清单对象
	 * @return 返回ArrayList对象
	 */
	public ArrayList<Goods> goReach(int pageCurrentFirst, int pageRows,
			Goods goodsReach) {
		return bm.goReach(pageCurrentFirst, pageRows, goodsReach);
	}

	/**
	 * 删除物流单
	 * 
	 * @param goId
	 *            物流Id
	 * @return 返回int
	 */
	public int goDele(int goId) {
		return bm.goDele(goId);
	}

	public int goInput(Goods goods) {
		return 0;
	}
}
