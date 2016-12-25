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
import org.lanqiao.wuliu.util.FormUtils;

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

		int currentPage = FormUtils.parseInt(req.getParameter("page"));
		int rowsPerPage = FormUtils.parseInt(req.getParameter("rows"));

		TrafficDaoImpl dao = new TrafficDaoImpl();
		List<Logistics> list = dao.trafficReach(currentPage, rowsPerPage);
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
			row.put("logCarLicense", logistics.getLogCarLicence());
			row.put("logCarDriver", logistics.getLogCarDriver());
			row.put("logCarPhone", logistics.getLogCarPhone());
			row.put("logCarPay", logistics.getLogCarPay());
			row.put("logPartner", logistics.getLogPartner());
			row.put("logType", logistics.getLogType());
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", dao.trafficCount());
		out.println(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}