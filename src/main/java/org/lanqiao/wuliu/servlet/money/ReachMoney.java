package org.lanqiao.wuliu.servlet.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
public class ReachMoney extends HttpServlet {

	private static final long serialVersionUID = -9148462469327101781L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int rowsPerPage = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		String moneyDate = request.getParameter("moneyDate");
		
		Object[] object1 = new Object[5];
		Object[] object2 = new Object[4];
		Object[] object3 = new Object[3];
		ArrayList<String> lists = new ExpentDaoImpl().getDate();
		for (String list : lists) {
			if (moneyDate != null && !moneyDate.equals("")
					&& !moneyDate.equals(null)) {
				list = moneyDate;
			}
			JSONObject row = new JSONObject();
			ArrayList<Object[]> list1 = new ExpentDaoImpl().getIncome1Date(
					(page - 1) * rowsPerPage, rowsPerPage, list);
			double sumIncome1 = 0;
			for (int i = 0; i < list1.size(); i++) {
				object1 = list1.get(i);
				sumIncome1 = (Double) object1[1]+(Double) object1[5] - ((Double) object1[2])
						- ((Double) object1[3]) - ((Double) object1[4])-(Double) object1[6];
			}

			ArrayList<Object[]> list2 = new ExpentDaoImpl().getIncome2Date(
					(page - 1) * rowsPerPage, rowsPerPage, list);
			double sumIncome2 = 0;
			for (int i = 0; i < list2.size(); i++) {
				object2 = list2.get(i);
				sumIncome2 = (Double) object2[3] - ((Double) object2[1])
						- ((Double) object2[2]);
			}

			double sumIncome = 0;
			if (sumIncome1 != 0 && sumIncome2 != 0) {
				sumIncome = sumIncome1 + sumIncome2;
			} else if (sumIncome1 != 0 && sumIncome2 == 0) {
				sumIncome = sumIncome1;
			} else if (sumIncome1 == 0 && sumIncome2 != 0) {
				sumIncome = sumIncome2;
			}

			ArrayList<Object[]> list3 = new ExpentDaoImpl().getMoney((page - 1)
					* rowsPerPage, rowsPerPage, list);
			double sumMoney = 0;
			double sumExpent = 0;
			int expId=0;
			for (int i = 0; i < list3.size(); i++) {
				object3 = list3.get(i);
				sumExpent = (Double) object3[0];
				expId=(Integer)object3[2];
			}

			if (sumIncome != 0 && sumExpent != 0) {
				sumMoney = sumIncome - ((Double) object3[0]);
			} else if (sumIncome != 0 && sumExpent == 0) {
				sumMoney = sumIncome;
			} else if (sumIncome == 0 && sumExpent != 0) {
				sumMoney = -sumExpent;
			}
			row.put("date", list);
			row.put("sumIncome", sumIncome);
			row.put("sumExpent", sumExpent);
			row.put("sumMoney", sumMoney);
			row.put("expId", expId);
			array.put(row);
			if (moneyDate != null && !moneyDate.equals("")
					&& !moneyDate.equals(null)) {
				break;
			}
		}
		json.put("rows", array);
		json.put("total", lists.size());
		out.println(json);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
