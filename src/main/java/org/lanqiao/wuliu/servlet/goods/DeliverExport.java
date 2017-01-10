package org.lanqiao.wuliu.servlet.goods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.dao.impl.TrafficDaoImpl;
import org.lanqiao.wuliu.util.ParseUtils;
import org.lanqiao.wuliu.util.XLSUtils;

/**
 * @author zooqi
 *
 */
@WebServlet(name = "deliverExport", urlPatterns = { "/deliverExport" })
public class DeliverExport extends HttpServlet {

	private static final long serialVersionUID = 6629643603430357245L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int logId = ParseUtils.parseInt(request.getParameter("logId"));
		String xlsType = ParseUtils.toLegalString(request.getParameter("xlsType"));

		TrafficDaoImpl dao = new TrafficDaoImpl();
		Logistics traffic = dao.getTraffic(logId);
		List<Goods> list = dao.getTrafficGoods(logId);

		Workbook wb = null;
		StringBuffer bashName = new StringBuffer(ParseUtils.formatDate(traffic.getLogSendDate())).append("+")
				.append(traffic.getLogType() == 0 ? "发车" : "到车").append("+").append(traffic.getLogContractNum())
				.append("+").append(traffic.getLogCarLicence()).append(".");
		switch (xlsType) {
		case "xlsx":
			wb = new XSSFWorkbook(new FileInputStream(request.getServletContext().getRealPath("/data/导出模板.xlsx")));
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(bashName.append("xlsx").toString().getBytes("GBK"), "ISO-8859-1"));
			break;
		case "xls":
		default:
			wb = new HSSFWorkbook(new FileInputStream(request.getServletContext().getRealPath("/data/导出模板.xls")));
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(bashName.append("xls").toString().getBytes("GBK"), "ISO-8859-1"));
		}

		response.setBufferSize(2048);
		XLSUtils.outputDeliver(traffic, list, wb, response.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
