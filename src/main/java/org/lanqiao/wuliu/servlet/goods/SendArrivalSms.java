package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.dao.impl.TrafficDaoImpl;
import org.lanqiao.wuliu.util.SmsUtils;

/**
 * 
 * @author zooqi
 *
 */
@WebServlet(name = "sendArrivalSms", urlPatterns = { "/sendArrivalSms" })
public class SendArrivalSms extends HttpServlet {

	private static final long serialVersionUID = 3974648283899910039L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String params = request.getParameter("params");
		JSONArray array = new JSONArray(params);

		List<String> phones = new LinkedList<String>();
		List<String> contents = new LinkedList<String>();
		List<Integer> ids = new LinkedList<Integer>();
		for (Object object : array) {
			JSONObject json = (JSONObject) object;

			ids.add(json.getInt("goId"));
			phones.add(json.getString("goForPhone"));
			StringBuffer content = new StringBuffer("尊敬的客户").append(json.getString("goForMan")).append("女士/先生,您的快递")
					.append(json.getString("goName")).append("已到达桂林百顺物流公司(地址：东二环德鑫市场院内百顺物流一号仓),请尽快来取件。详情请咨询0773-22034");
			contents.add(content.toString());
		}
		SmsUtils.init();
		int remain = SmsUtils.getRemain();
		if (remain < phones.size()) {
			out.println("{\"success\":false,\"errMsg\":\"余额不足, 无法发送！\"}");
		}

		new TrafficDaoImpl().saveSmsStatus(ids);
		for (int i = 0; i < phones.size(); i++) {
			try {
				SmsUtils.sendOnce(phones.get(i), contents.get(i));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.println("{\"success\":true}");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
