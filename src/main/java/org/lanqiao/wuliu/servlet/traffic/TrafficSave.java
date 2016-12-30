package org.lanqiao.wuliu.servlet.traffic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.dao.impl.TrafficDaoImpl;
import org.lanqiao.wuliu.util.ParseUtils;

/**
 * 
 * @author zooqi
 *
 */
@WebServlet(name = "trafficSave", urlPatterns = { "/trafficSave" })
public class TrafficSave extends HttpServlet {

	private static final long serialVersionUID = 4178433967004487118L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int logId = ParseUtils.parseInt(request.getParameter("logId"));
		String logContractNum = request.getParameter("logContractNum");
		Date logSendDate = ParseUtils.parseDate(request.getParameter("logSendDate"));
		String logSiteStart = request.getParameter("logSiteStart");
		String logSiteEnd = request.getParameter("logSiteEnd");
		String logCarLicence = request.getParameter("logCarLicence");
		String logCarDriver = request.getParameter("logCarDriver");
		String logCarPhone = request.getParameter("logCarPhone");
		double logCarPay = ParseUtils.parseDouble(request.getParameter("logCarPay"));
		double logUnloadPay = ParseUtils.parseDouble(request.getParameter("logUnloadPay"));
		String logPartner = request.getParameter("logPartner");
		int logType = ParseUtils.parseInt(request.getParameter("logType"));

		Logistics traffic = new Logistics();
		traffic.setLogId(logId);
		traffic.setLogContractNum(logContractNum);
		traffic.setLogSendDate(logSendDate);
		traffic.setLogSiteStart(logSiteStart);
		traffic.setLogSiteEnd(logSiteEnd);
		traffic.setLogCarLicence(logCarLicence);
		traffic.setLogCarDriver(logCarDriver);
		traffic.setLogCarPhone(logCarPhone);
		traffic.setLogCarPay(logCarPay);
		traffic.setLogUnloadPay(logUnloadPay);
		traffic.setLogPartner(logPartner);
		traffic.setLogType(logType);

		TrafficDaoImpl dao = new TrafficDaoImpl();
		int count = dao.trafficSave(traffic);
		if (count == 1) {
			out.println("{\"success\":true}");
		} else {
			out.println("{\"success\":false}");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
