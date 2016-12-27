package org.lanqiao.wuliu.servlet.traffic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.dao.impl.TrafficDaoImpl;
import org.lanqiao.wuliu.util.FormUtils;

/**
 * 
 * @author zooqi
 *
 */
@WebServlet(name = "trafficDelete", urlPatterns = { "/trafficDelete" })
public class TrafficDelete extends HttpServlet {

	private static final long serialVersionUID = 2166322326621435632L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int logId = FormUtils.parseInt(request.getParameter("logId"));
		TrafficDaoImpl dao = new TrafficDaoImpl();
		int count = dao.trafficDelete(logId);
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
