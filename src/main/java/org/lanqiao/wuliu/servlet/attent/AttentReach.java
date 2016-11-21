package org.lanqiao.wuliu.servlet.attent;

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
import org.lanqiao.wuliu.bean.Attent;
import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.service.impl.HRManageServiceImpl;

@WebServlet(name = "attentReach", urlPatterns = { "/attentReach" })
public class AttentReach extends HttpServlet {

	private static final long serialVersionUID = 8328324139316754400L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int rowsPerPage = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));

		String attentDate = request.getParameter("attentDate");

		String b = request.getParameter("attentNum");
		double attentNum = 0;
		if (b != null && b.equals("")) {
			attentNum = Double.parseDouble(b);
		}
		String c = request.getParameter("attentReasonNum");
		double attentReasonNum = 0;
		if (c != null && c.equals("")) {
			attentReasonNum = Double.parseDouble(c);
		}
		String attentReason = request.getParameter("attentReason");
		String d = request.getParameter("attentOverTimeNum");
		double attentOverTimeNum = 0;
		if (d != null && d.equals("")) {
			attentOverTimeNum = Double.parseDouble(d);
		}
		String e = request.getParameter("attentOverTimePay");
		double attentOverTimePay = 0;
		if (e != null && e.equals("")) {
			attentOverTimePay = Double.parseDouble(e);
		}
		String f = request.getParameter("attentBonus");
		double attentBonus = 0;
		if (f != null && f.equals("")) {
			attentBonus = Double.parseDouble(f);
		}
		String attentRemark = request.getParameter("attentRemark");
		String empName = request.getParameter("empName");

		Attent attentReach = new Attent();
		Emp emp = new Emp();
		emp.setEmpName(empName);
		attentReach.setEmp(emp);
		attentReach.setAttentNum(attentNum);
		attentReach.setAttentReasonNum(attentReasonNum);
		attentReach.setAttentReason(attentReason);
		attentReach.setAttentOverTimeNum(attentOverTimeNum);
		attentReach.setAttentOverTimePay(attentOverTimePay);
		attentReach.setAttentBonus(attentBonus);
		attentReach.setAttentRemark(attentRemark);

		HRManageServiceImpl hsi = new HRManageServiceImpl();

		ArrayList<Attent> attents = hsi.attentSel((page - 1) * rowsPerPage, rowsPerPage, attentReach, attentDate);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Attent attent : attents) {
			JSONObject row = new JSONObject();
			row.put("attentNum", attent.getAttentNum());
			row.put("attentReasonNum", attent.getAttentReasonNum());
			row.put("attentReason", attent.getAttentReason());
			row.put("attentDate", attent.getAttentDate());
			row.put("attentRemark", attent.getAttentRemark());
			row.put("attentId", attent.getAttentId());
			row.put("attentOverTimeNum", attent.getAttentOverTimeNum());
			row.put("attentOverTimePay", attent.getAttentOverTimePay());
			row.put("empNum", attent.getEmp().getEmpNum());
			row.put("empName", attent.getEmp().getEmpName());
			row.put("attentBonus", attent.getAttentBonus());
			row.put("empId", attent.getEmp().getEmpId());
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", hsi.attentCount());
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
