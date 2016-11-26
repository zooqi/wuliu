package org.lanqiao.wuliu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;

/**
 * 业务管理
 * 
 * @author 杨明静
 */
public class BusinessManage extends BaseDaoImpl {
	/**
	 * 添加货物信息
	 * 
	 * @param goods
	 *            货物对象
	 * @return 返回int
	 */
	public int goInsert(Goods goods) {
		String sql = "INSERT INTO goods(goBank=?,goName=?,goNum=?,goPack=?,goWeight=?,goVolume=?,"
				+ "goSendMan=?,goSendPhone=?,goSendSddress=?,goForMan=?,goForPhone=?,goForAddress=?,goGetWay=?,"
				+ "goPayWay=?,goPay=?,goInsurancePay=?,goReplacePay=?,goCommission=?,goDamagePay=?,goMessage=?,"
				+ "goTransitPay=?,goSiteEnd=?,goRemark=?,logId=?) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { goods.getGoBank(), goods.getGoName(),
				goods.getGoNum(), goods.getGoPack(), goods.getGoweight(),
				goods.getGoVolume(), goods.getGoSendMan(),
				goods.getGoSendPhone(), goods.getGoSendAddress(),
				goods.getGoForMan(), goods.getGoForPhone(),
				goods.getGoForAddress(), goods.getGoGetWay(),
				goods.getGoPayWay(), goods.getGoPay(),
				goods.getGoInsurancePay(), goods.getGoReplacePay(),
				goods.getGoCommission(), goods.getGoDamagePay(),
				goods.getGoTransitPay(), goods.getGoSiteEnd(),
				goods.getGoRemark(), goods.getLogistics().getLogId() };
		return cud(sql, params);
	}

	/**
	 * 添加物流信息
	 * 
	 * @param logistics
	 *            物流对象
	 * @return 插入的记录数
	 */
	public int loAdd(Logistics logistics) {
		String sql = "INSERT INTO logistics(loContractNum=?,loSendDate=?,logSiteStart=?,logSiteEnd=?,logCarLicence=?,logCarDriver=?,logCarPhone=?,logPartner=?) VALUES(?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { logistics.getLogContractNum(),
				logistics.getLogSendDate(), logistics.getLogSiteStart(),
				logistics.getLogSiteEnd(), logistics.getLogCarLicence(),
				logistics.getLogCarDriver(), logistics.getLogCarPhone(),
				logistics.getLogPartner() };
		return cud(sql, params);
	}

	/**
	 * 统计goods表的记录数
	 * 
	 * @return 返回int
	 */
	public int goConut() {
		String sql = "SELECT COUNT(goId) FROM goods";
		ResultSet rs = select(sql);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
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
		String sql = "UPDATE goods SET goBank=?,goName=?,goNum=?,goPack=?,goWeight=?,goVolume=?,"
				+ "goSendMan=?,goSendPhone=?,goSendSddress=?,goForMan=?,goForPhone=?,goForAddress=?,goGetWay=?,"
				+ "goPayWay=?,goPay=?,goInsurancePay=?,goReplacePay=?,goCommission=?,goDamagePay=?,"
				+ "goTransitPay=?,goSiteEnd=?,goRemark=?,logId=? WHERE goId=?";
		Object[] params = new Object[] { goods.getGoBank(), goods.getGoName(),
				goods.getGoNum(), goods.getGoBank(), goods.getGoweight(),
				goods.getGoVolume(), goods.getGoSendMan(),
				goods.getGoSendPhone(), goods.getGoSendAddress(),
				goods.getGoForMan(), goods.getGoForPhone(),
				goods.getGoForAddress(), goods.getGoGetWay(),
				goods.getGoPayWay(), goods.getGoPay(),
				goods.getGoInsurancePay(), goods.getGoReplacePay(),
				goods.getGoCommission(), goods.getGoDamagePay(),
				goods.getGoTransitPay(), goods.getGoSiteEnd(),
				goods.getGoRemark(), goods.getLogistics().getLogId(), goId };
		return cud(sql, params);
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
		ArrayList<Goods> ar = new ArrayList<Goods>();
		StringBuffer sql = new StringBuffer(
				"SELECT goBank,goName,goNum,goPack,goWeight,goVolume,goSendMan,goSendPhone,goSendAddress,goForMan,goForPhone,goForAddress,goGetWay,goPayWay,goPay,goInsurancePay,goReplacePay,goCommission,goDamagePay,goTransitPay,goSiteEnd,goRemark,goId FROM goods g,logistics l  WHERE g.logId=l.logId AND l.logSiteEnd ='桂林'");
		if (goodsReach.getLogistics().getLogCarLicence() != null
				&& !goodsReach.getLogistics().getLogCarLicence().equals("")) {
			sql.append("AND l.logCarLicence like '%")
					.append(goodsReach.getLogistics().getLogCarLicence())
					.append("%' ");
		}
		if (goodsReach.getLogistics().getLogSendDate() != null
				&& !goodsReach.getLogistics().getLogSendDate().equals("")) {
			sql.append("AND l.logSendDate like '%")
					.append(goodsReach.getLogistics().getLogSendDate())
					.append("%' ");
		}
		sql.append(" ORDER BY g.goId LIMIT ?, ?");
		ResultSet rs = select(sql.toString(), new Object[] { pageCurrentFirst,
				pageRows });
		try {
			while (rs.next()) {
				Goods goods = new Goods();
				//ogistics log = new Logistics();
				goods.setGoBank(rs.getString(1));
				goods.setGoName(rs.getString(2));
				goods.setGoNum(rs.getInt(3));
				goods.setGoPack(rs.getString(4));
				goods.setGoweight(rs.getDouble(5));
				goods.setGoVolume(rs.getDouble(6));
				goods.setGoSendMan(rs.getString(7));
				goods.setGoSendPhone(rs.getString(8));
				goods.setGoSendAddress(rs.getString(9));
				goods.setGoForMan(rs.getString(10));
				goods.setGoForPhone(rs.getString(11));
				goods.setGoForAddress(rs.getString(12));
				goods.setGoGetWay(rs.getString(13));
				goods.setGoPayWay(rs.getString(14));
				goods.setGoPay(rs.getDouble(15));
				goods.setGoInsurancePay(rs.getDouble(16));
				goods.setGoReplacePay(rs.getDouble(17));
				goods.setGoCommission(rs.getDouble(18));
				goods.setGoDamagePay(rs.getDouble(19));
				goods.setGoTransitPay(rs.getShort(20));
				goods.setGoSiteEnd(rs.getString(21));
				goods.setGoRemark(rs.getString(22));
				goods.setGoId(rs.getInt(23));
				ar.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}

	/**
	 * 删除物流单
	 * 
	 * @param goId
	 *            物流Id
	 * @return 返回int
	 */
	public int goDele(int goId) {
		String sql = "DELETE FROM goods WHERE goId=?";
		return cud(sql, new Object[] { goId });
	}
	
	/**
	 * 查找到货物品清单信息
	 * 
	 * @param pageCurrentFirst
	 *            某页的第一条记录
	 * @param pageRows
	 *            一页的记录数
	 * @param goodsReach
	 *            物品清单对象
	 * @return 返回ArrayList对象
	 */
	public ArrayList<Goods> goReachs(int pageCurrentFirst, int pageRows,
			Goods goodsReach) {
		ArrayList<Goods> ar = new ArrayList<Goods>();
		StringBuffer sql = new StringBuffer(
				"SELECT goBank,goName,goNum,goPack,goWeight,goVolume,goSendMan,goSendPhone,goSendAddress,goForMan,goForPhone,goForAddress,goGetWay,goPayWay,goPay,goInsurancePay,goReplacePay,goCommission,goDamagePay,goTransitPay,goSiteEnd,goRemark,goId FROM goods g,logistics l  WHERE g.logId=l.logId AND l.logSiteEnd != '桂林'");
		if (goodsReach.getLogistics().getLogCarLicence() != null
				&& !goodsReach.getLogistics().getLogCarLicence().equals("")) {
			sql.append("AND l.logCarLicence like '%")
					.append(goodsReach.getLogistics().getLogCarLicence())
					.append("%' ");
		}
		if (goodsReach.getLogistics().getLogSendDate() != null
				&& !goodsReach.getLogistics().getLogSendDate().equals("")) {
			sql.append("AND l.logSendDate like '%")
					.append(goodsReach.getLogistics().getLogSendDate())
					.append("%' ");
		}
		sql.append(" ORDER BY g.goId LIMIT ?, ?");
		ResultSet rs = select(sql.toString(), new Object[] { pageCurrentFirst,
				pageRows });
		try {
			while (rs.next()) {
				Goods goods = new Goods();
				//ogistics log = new Logistics();
				goods.setGoBank(rs.getString(1));
				goods.setGoName(rs.getString(2));
				goods.setGoNum(rs.getInt(3));
				goods.setGoPack(rs.getString(4));
				goods.setGoweight(rs.getDouble(5));
				goods.setGoVolume(rs.getDouble(6));
				goods.setGoSendMan(rs.getString(7));
				goods.setGoSendPhone(rs.getString(8));
				goods.setGoSendAddress(rs.getString(9));
				goods.setGoForMan(rs.getString(10));
				goods.setGoForPhone(rs.getString(11));
				goods.setGoForAddress(rs.getString(12));
				goods.setGoGetWay(rs.getString(13));
				goods.setGoPayWay(rs.getString(14));
				goods.setGoPay(rs.getDouble(15));
				goods.setGoInsurancePay(rs.getDouble(16));
				goods.setGoReplacePay(rs.getDouble(17));
				goods.setGoCommission(rs.getDouble(18));
				goods.setGoDamagePay(rs.getDouble(19));
				goods.setGoTransitPay(rs.getShort(20));
				goods.setGoSiteEnd(rs.getString(21));
				goods.setGoRemark(rs.getString(22));
				goods.setGoId(rs.getInt(23));
				ar.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}
}