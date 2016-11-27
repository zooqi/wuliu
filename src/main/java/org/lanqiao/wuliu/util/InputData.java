package org.lanqiao.wuliu.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.service.impl.BusinessManageServiceImpl;

public class InputData {

	public static void input(String fileName) {

		BusinessManageServiceImpl bms = null;

		Goods goods = null;
		org.lanqiao.wuliu.bean.Logistics log = null;

		FileInputStream file;
		HSSFWorkbook workbook = null;
		try {
			file = new FileInputStream(new File(fileName));
			workbook = new HSSFWorkbook(file);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		int j = 0;
		while (rowIterator.hasNext()) {// 对行迭代
			Row row = rowIterator.next();
			if (row.getRowNum() == 0)// excel第一行（清单）
			{
				log = new org.lanqiao.wuliu.bean.Logistics();

			}
			if (row.getRowNum() > 1)// 第2行后，每行都是一个物流单
			{
				goods = new Goods();
			}
			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {// 对列迭代开始

				Cell cell = cellIterator.next();
				int cellIndex = cell.getColumnIndex();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (cellIndex == 4)// 件数
					{
						goods.setGoNum(new Double(cell.getNumericCellValue())
								.intValue());
					} else if (cellIndex == 5)// 重量
					{
						goods.setGoWeight(new Double(cell.getNumericCellValue())
								.doubleValue());
					} else if (cellIndex == 6)// 体积
					{
						goods.setGoVolume(new Double(cell.getNumericCellValue())
								.doubleValue());
					} else if (cellIndex == 7)// 发货人
					{
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoSendMan(df.format(cell.getNumericCellValue()));
					} else if (cellIndex == 8) {// 发货人电话
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoSendPhone(df.format(cell
								.getNumericCellValue()));
					} else if (cellIndex == 9) {
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoSendAddress(df.format(cell
								.getNumericCellValue()));
					} else if (cellIndex == 10) {// 收货人
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoForMan(df.format(cell.getNumericCellValue()));
					} else if (cellIndex == 11) {
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoForPhone(df.format(cell
								.getNumericCellValue()));
					} else if (cellIndex == 12) {
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoForAddress(df.format(cell
								.getNumericCellValue()));

					} else if (cellIndex == 13)// 提货方式
					{
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoGetWay(df.format(cell.getStringCellValue()));
					} else if (cellIndex == 14) {// 付款方式
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoPayWay(df.format(cell.getStringCellValue()));
					} else if (cellIndex == 15) {// 运费
						goods.setGoPay(new Double(cell.getNumericCellValue())
								.doubleValue());
					} else if (cellIndex == 16) {// 保价费
						goods.setGoInsurancePay(new Double(cell
								.getNumericCellValue()).doubleValue());
					} else if (cellIndex == 17) {// 代收货款
						goods.setGoReplacePay(new Double(cell
								.getNumericCellValue()).doubleValue());
					} else if (cellIndex == 18) {// 回扣
						goods.setGoCommission(new Double(cell
								.getNumericCellValue()).doubleValue());
					} else if (cellIndex == 19) {// 货款扣
						goods.setGoDamagePay(new Double(cell
								.getNumericCellValue()).doubleValue());
					} else if (cellIndex == 20) {// 中转费
						goods.setGoTransitPay(new Double(cell
								.getNumericCellValue()).doubleValue());
					} else if (cellIndex == 21) {// 货物终点站
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoSiteEnd(df.format(cell.getStringCellValue()));
					} else if (cellIndex == 22) {// 货物备注
						DecimalFormat df = new DecimalFormat("0");
						goods.setGoRemark(df.format(cell.getStringCellValue()));
					}
					break;
				case Cell.CELL_TYPE_STRING:
					if (row.getRowNum() > 1) {
						if (cellIndex == 1)// 票号
						{
							goods.setGoBank(cell.getStringCellValue());
						} else if (cellIndex == 2)// 货名
						{
							goods.setGoName(cell.getStringCellValue());
						}
					}
					if (row.getRowNum() == 0) {
						String listValue = cell.getStringCellValue();
						System.out.println(listValue);
						String str_arr[] = listValue.split("\\s+");
						for (int i = 0; i < str_arr.length; i++)// 循环6次
						{
							String arr[] = str_arr[i].split("：");
							if (i == 0)// 清单编号
							{
								log.setLogContractNum(arr[1]);
							} else if (i == 1)// 发车日期
							{
								SimpleDateFormat sdf = new SimpleDateFormat(
										"yyyy-mm-dd");

								try {
									log.setLogSendDate(new Date(sdf.parse(
											arr[1]).getTime()));
								} catch (ParseException e) {
									e.printStackTrace();
								}// 涉及到把字符串转换为日期
							} else if (i == 3)// 到站
							{
								log.setLogSiteStart(arr[1]);
							} else if (i == 4) {
								log.setLogSiteEnd(arr[1]);
							} else if (i == 5)// 车牌号
							{
								log.setLogCarLicence(arr[1]);
							} else if (i == 6)// 司机姓名
							{
								log.setLogCarDriver(arr[1]);
							} else if (i == 7)// 司机电话
							{
								log.setLogCarPhone(arr[1]);
							}
						}
						bms.loAdd(log);
					}
					break;
				}
			}// 对列迭代结束
			if (row.getRowNum() > 1) {
				j++;
			}
		}
	}
}
