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
import org.lanqiao.wuliu.dao.impl.TrafficDaoImpl;

/**
 * @author zooqi
 *
 */
@WebServlet(name = "availableDepart", urlPatterns = { "/availableDepart" })
public class AvailableDepart extends HttpServlet {

	private static final long serialVersionUID = -6951136484802450687L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		TrafficDaoImpl dao = new TrafficDaoImpl();
		List<Object[]> list = dao.availableDepart();
		JSONArray array = new JSONArray();
		for (Object[] objects : list) {
			JSONObject row = new JSONObject();
			row.put("logId", objects[0]);
			row.put("logContractNum", objects[1]);

			Date date = (Date) objects[2];
			String logSendDate = (date == null) ? "" : new SimpleDateFormat("yyyy-MM-dd").format(date);
			row.put("logSendDate", logSendDate);
			row.put("logSiteStart", objects[3]);
			row.put("logSiteEnd", objects[4]);
			row.put("logCarLicense", objects[5]);
			row.put("logCarDriver", objects[6]);
			row.put("text", logSendDate + " | 起点:" + objects[3] + " | 终点:" + objects[4] + " | 合同编号:" + objects[1]
					+ " | 车牌号:" + objects[5]);
			row.put("value", objects[0]);
			array.put(row);
		}
		out.println(array);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
