package org.lanqiao.wuliu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;

public class XLSUtils {

	public static Object[] importArrival(InputStream file, String fileName)
			throws IllegalArgumentException, IOException {
		String extName = FilenameUtils.getExtension(fileName);
		if (!extName.equals("xls") && !extName.equals("xlsx")) {
			throw new IllegalArgumentException("不支持的文件类型！");
		}

		Workbook wb = null;
		Logistics traffic = new Logistics();
		List<Goods> list = new LinkedList<Goods>();
		if (extName.equals("xls")) {
			wb = new HSSFWorkbook(file);
		} else {
			wb = new XSSFWorkbook(file);
		}
		Sheet sheet = wb.getSheetAt(0);

		Row trafficRow = sheet.getRow(1);
		traffic.setLogContractNum(trafficRow.getCell(6).getStringCellValue());
		traffic.setLogSendDate(trafficRow.getCell(2).getDateCellValue());
		traffic.setLogSiteStart(trafficRow.getCell(10).getStringCellValue());
		traffic.setLogSiteEnd(trafficRow.getCell(12).getStringCellValue());
		traffic.setLogCarLicence(trafficRow.getCell(14).getStringCellValue());
		traffic.setLogCarDriver(trafficRow.getCell(22).getStringCellValue());
		trafficRow.getCell(24).setCellType(Cell.CELL_TYPE_STRING);
		traffic.setLogCarPhone(trafficRow.getCell(24).getStringCellValue());
		traffic.setLogCarPay(trafficRow.getCell(16).getNumericCellValue());
		traffic.setLogPartner(trafficRow.getCell(19).getStringCellValue());
		traffic.setLogType(1);

		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row.getCell(0).getCellType() != Cell.CELL_TYPE_NUMERIC) {
				break;
			}

			Goods goods = new Goods();
			goods.setGoBank(row.getCell(1).getStringCellValue());
			goods.setGoName(row.getCell(2).getStringCellValue());
			goods.setGoNum(new Double(row.getCell(3).getNumericCellValue()).intValue());
			goods.setGoPack(row.getCell(4).getStringCellValue());
			row.getCell(5).setCellType(Cell.CELL_TYPE_NUMERIC);
			row.getCell(6).setCellType(Cell.CELL_TYPE_NUMERIC);
			goods.setGoWeight(row.getCell(5).getNumericCellValue());
			goods.setGoVolume(row.getCell(6).getNumericCellValue());
			goods.setGoSiteEnd(row.getCell(8).getStringCellValue());
			goods.setGoSendMan(row.getCell(9).getStringCellValue());
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			goods.setGoSendPhone(row.getCell(10).getStringCellValue());
			goods.setGoSendAddress(row.getCell(11).getStringCellValue());
			goods.setGoForMan(row.getCell(12).getStringCellValue());
			row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
			goods.setGoForPhone(row.getCell(13).getStringCellValue());
			goods.setGoForAddress(row.getCell(14).getStringCellValue());
			goods.setGoGetWay(row.getCell(15).getStringCellValue());
			goods.setGoPayWay(row.getCell(16).getStringCellValue());
			row.getCell(17).setCellType(Cell.CELL_TYPE_NUMERIC);
			row.getCell(18).setCellType(Cell.CELL_TYPE_NUMERIC);
			row.getCell(19).setCellType(Cell.CELL_TYPE_NUMERIC);
			row.getCell(20).setCellType(Cell.CELL_TYPE_NUMERIC);
			row.getCell(21).setCellType(Cell.CELL_TYPE_NUMERIC);
			row.getCell(22).setCellType(Cell.CELL_TYPE_NUMERIC);
			goods.setGoPay(row.getCell(17).getNumericCellValue());
			goods.setGoInsurancePay(row.getCell(18).getNumericCellValue());
			goods.setGoReplacePay(row.getCell(19).getNumericCellValue());
			goods.setGoCommission(row.getCell(20).getNumericCellValue());
			goods.setGoDamagePay(row.getCell(21).getNumericCellValue());
			goods.setGoTransitPay(row.getCell(22).getNumericCellValue());
			goods.setGoRemark(row.getCell(24).getStringCellValue());
			list.add(goods);
		}

		wb.close();
		file.close();

		Object[] objects = new Object[] { traffic, list };
		return objects;
	}
}