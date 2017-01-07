package org.lanqiao.wuliu.servlet.traffic;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.dao.impl.TrafficDaoImpl;
import org.lanqiao.wuliu.util.ParseUtils;

/**
 * @author zooqi
 *
 */
@WebServlet(name = "trafficReach", urlPatterns = { "/trafficReach" })
public class TrafficReach extends HttpServlet {

	private static final long serialVersionUID = -4932550571253301820L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		int currentPage = ParseUtils.parseInt(req.getParameter("page"));
		int rowsPerPage = ParseUtils.parseInt(req.getParameter("rows"));

		String searchLogSendDate = ParseUtils.toLegalString(req.getParameter("searchLogSendDate"));
		String searchLogContractNum = ParseUtils.toLegalString(req.getParameter("searchLogContractNum"));
		String searchLogCarLicence = ParseUtils.toLegalString(req.getParameter("searchLogCarLicence"));

		TrafficDaoImpl dao = new TrafficDaoImpl();
		List<Logistics> list = dao.trafficReach(currentPage, rowsPerPage, searchLogSendDate, searchLogContractNum,
				searchLogCarLicence);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Logistics logistics : list) {
			JSONObject row = new JSONObject();
			row.put("logId", logistics.getLogId());
			row.put("logContractNum", logistics.getLogContractNum());

			Date date = logistics.getLogSendDate();
			row.put("logSendDate", (date == null) ? "" : new SimpleDateFormat("yyyy-MM-dd").format(date));
			row.put("logSiteStart", logistics.getLogSiteStart());
			row.put("logSiteEnd", logistics.getLogSiteEnd());
			row.put("logCarLicence", logistics.getLogCarLicence());
			row.put("logCarDriver", logistics.getLogCarDriver());
			row.put("logCarPhone", logistics.getLogCarPhone());
			row.put("logCarPay", logistics.getLogCarPay());
			row.put("logUnloadPay", logistics.getLogUnloadPay());
			row.put("logPartner", logistics.getLogPartner());
			row.put("logType", logistics.getLogType());
			row.put("goodsCount", dao.goodsCount(logistics.getLogId()));
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", dao.trafficCount(searchLogSendDate, searchLogContractNum, searchLogCarLicence));
		out.println(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
