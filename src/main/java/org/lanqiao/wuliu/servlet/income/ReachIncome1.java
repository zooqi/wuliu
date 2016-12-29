package org.lanqiao.wuliu.servlet.income;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.dao.impl.ExpentDaoImpl;

@WebServlet(name = "reachIncome1", urlPatterns = { "/reachIncome1" })
public class ReachIncome1 extends HttpServlet{
	private static final long serialVersionUID = -7583949689000073592L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int rowsPerPage = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		String logSendDate = request.getParameter("logSendDate");
		if (logSendDate != null && !logSendDate.equals("")) {
			try {
				new SimpleDateFormat("yyyy-MM-dd").parse(logSendDate);
			} catch (Exception e) {
				return;
			}
		}
		String logCarLicence=request.getParameter("logCarLicence");
		
		ArrayList<Object[]> list=new ExpentDaoImpl().getIncome1((page - 1) * rowsPerPage, rowsPerPage,logSendDate,logCarLicence);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for(Object[] object:list){
			JSONObject row = new JSONObject();
			double sumMoney=(Double)object[2]+(Double)object[7]-(Double)object[3]-(Double)object[4]-(Double)object[6]-(Double)object[8];
			row.put("logSendDate", object[0]);
			row.put("logCarLicence", object[1]);
			row.put("sumGoPay", object[2]);
			row.put("sumGoDamagePay", object[3]);
			row.put("sumGoCommission", object[4]);
			row.put("logId", object[5]);
			row.put("sumLogCarPay", object[6]);
			row.put("sumGoInsurancePay", object[7]);
			row.put("logUnloadPay", object[8]);
			row.put("sumMoney", sumMoney);
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
