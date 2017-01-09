package org.lanqiao.wuliu.servlet.expent;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.bean.Expent;
import org.lanqiao.wuliu.dao.impl.ExpentDaoImpl;

@WebServlet(name = "expReach", urlPatterns = { "/expReach" })
public class ExpReach extends HttpServlet {

	private static final long serialVersionUID = -5804840185920561767L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int rowsPerPage = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));

		String expEmpNum = request.getParameter("expEmpNum");
		String expEmpName = request.getParameter("expEmpName");
		String expFunction = request.getParameter("expFunction");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		String expDate = request.getParameter("expDate");

		Expent exp = new Expent();

		exp.setExpEmpName(expEmpName);
		exp.setExpEmpNum(expEmpNum);
		exp.setExpFunction(expFunction);

		ExpentDaoImpl edi = new ExpentDaoImpl();

		ArrayList<Expent> expents = edi.expSelect((page - 1) * rowsPerPage, rowsPerPage, exp, expDate);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Expent expent : expents) {
			JSONObject row = new JSONObject();
			row.put("expId", expent.getExpId());
			row.put("expEmpNum", expent.getExpEmpNum());
			row.put("expEmpName", expent.getExpEmpName());
			row.put("expFunction", expent.getExpFunction());
			row.put("expMoney", expent.getExpMoney());
			row.put("expDate", expent.getExpDate());
			row.put("expRemark", expent.getExpRemark());
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", edi.expCount());
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
