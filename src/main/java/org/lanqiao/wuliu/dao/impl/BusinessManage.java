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
		Object[] params = new Object[] { goods.getGoBank(), goods.getGoName(), goods.getGoNum(), goods.getGoPack(),
				goods.getGoWeight(), goods.getGoVolume(), goods.getGoSendMan(), goods.getGoSendPhone(),
				goods.getGoSendAddress(), goods.getGoForMan(), goods.getGoForPhone(), goods.getGoForAddress(),
				goods.getGoGetWay(), goods.getGoPayWay(), goods.getGoPay(), goods.getGoInsurancePay(),
				goods.getGoReplacePay(), goods.getGoCommission(), goods.getGoDamagePay(), goods.getGoTransitPay(),
				goods.getGoSiteEnd(), goods.getGoRemark(), goods.getLogistics().getLogId() };
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
		Object[] params = new Object[] { logistics.getLogContractNum(), logistics.getLogSendDate(),
				logistics.getLogSiteStart(), logistics.getLogSiteEnd(), logistics.getLogCarLicence(),
				logistics.getLogCarDriver(), logistics.getLogCarPhone(), logistics.getLogPartner() };
		return cud(sql, params);
	}

	/**
	 * 物流记录数
	 * 
	 * @return 物流记录数
	 */
	public int goCount() {
		ResultSet rs = select("SELECT COUNT(*) FROM goods");
		int count = 0;
		try {
			if (rs.next()) {
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
		Object[] params = new Object[] { goods.getGoBank(), goods.getGoName(), goods.getGoNum(), goods.getGoBank(),
				goods.getGoWeight(), goods.getGoVolume(), goods.getGoSendMan(), goods.getGoSendPhone(),
				goods.getGoSendAddress(), goods.getGoForMan(), goods.getGoForPhone(), goods.getGoForAddress(),
				goods.getGoGetWay(), goods.getGoPayWay(), goods.getGoPay(), goods.getGoInsurancePay(),
				goods.getGoReplacePay(), goods.getGoCommission(), goods.getGoDamagePay(), goods.getGoTransitPay(),
				goods.getGoSiteEnd(), goods.getGoRemark(), goods.getLogistics().getLogId(), goId };
		return cud(sql, params);
	}

	/**
	 * 获取物流信息列表(发货和到货)
	 * 
	 * @param goType
	 *            发、到货类型
	 * @param currentPage
	 *            当前页
	 * @param rowsPerPage
	 *            每页记录数
	 * @param srhLicence
	 *            车牌号关键字
	 * @param srhDate
	 *            日期字符串(yyyy-MM-dd)
	 * @return 物流信息列表
	 */
	public ArrayList<Goods> goReach(int goType, int currentPage, int rowsPerPage, String srhLicence,
			String srhDateStr) {
		ArrayList<Goods> ar = new ArrayList<Goods>();
		StringBuffer sql = new StringBuffer(
				"SELECT goBank,goName,goNum,goPack,goWeight,goVolume,goSendMan,goSendPhone,goSendAddress,goForMan,goForPhone,goForAddress,goGetWay,goPayWay,goPay,goInsurancePay,goReplacePay,goCommission,goDamagePay,goTransitPay,goSiteEnd,goRemark,goId,goType,g.logId,l.logSendDate,l.logCarLicence,l.logCarDriver FROM logistics l RIGHT JOIN goods g ON l.logId = g.logId WHERE goType = ? ");

		if (srhLicence != null && !srhLicence.equals("")) {
			sql.append("AND l.logCarLicence like '%").append(srhLicence).append("%' ");
		}
		if (srhDateStr != null && !srhDateStr.equals("")) {
			sql.append("AND l.logSendDate = '").append(srhDateStr).append("' ");
		}
		sql.append(" ORDER BY g.goId LIMIT ?, ?");// 待定
		ResultSet rs = select(sql.toString(), new Object[] { goType, (currentPage - 1), rowsPerPage });
		try {
			while (rs.next()) {
				Goods goods = new Goods();
				Logistics logistics = new Logistics();
				goods.setGoBank(rs.getString(1));
				goods.setGoName(rs.getString(2));
				goods.setGoNum(rs.getInt(3));
				goods.setGoPack(rs.getString(4));
				goods.setGoWeight(rs.getDouble(5));
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
				goods.setGoTransitPay(rs.getDouble(20));
				goods.setGoSiteEnd(rs.getString(21));
				goods.setGoRemark(rs.getString(22));
				goods.setGoId(rs.getInt(23));
				goods.setGoType(rs.getInt(24));

				logistics.setLogId(rs.getInt(25));
				logistics.setLogSendDate(rs.getDate(26));
				logistics.setLogCarLicence(rs.getString(27));
				logistics.setLogCarDriver(rs.getString(28));

				goods.setLogistics(logistics);
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

}
