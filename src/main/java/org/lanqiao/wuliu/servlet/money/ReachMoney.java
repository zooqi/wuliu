package org.lanqiao.wuliu.servlet.money;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.dao.impl.ExpentDaoImpl;

@WebServlet(name = "reachMoney", urlPatterns = { "/reachMoney" })
public class ReachMoney extends HttpServlet{

	private static final long serialVersionUID = -9148462469327101781L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String moneyDate=request.getParameter("moneyDate");
		System.out.println(moneyDate);
		ArrayList<Object[]> list=new ExpentDaoImpl().getMoney(moneyDate);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for(Object[] object:list){
			JSONObject row = new JSONObject();
			row.put("sumExpent", object[0]);
			row.put("expId", object[1]);
			row.put("date", object[2]);
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", list.size());
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
