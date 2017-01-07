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
import org.lanqiao.wuliu.dao.impl.HrDaoImpl;

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
		String empNum=request.getParameter("empNum");
		String empName = request.getParameter("empName");
		
		Attent attentReach = new Attent();
		Emp emp = new Emp();
		emp.setEmpName(empName);
		emp.setEmpNum(empNum);
		attentReach.setEmp(emp);
		
		HrDaoImpl hd=new HrDaoImpl();

		ArrayList<Attent> attents = hd.attentSel((page - 1) * rowsPerPage, rowsPerPage, attentReach, attentDate);
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
			row.put("empDepart", attent.getEmp().getEmpDepart());
			row.put("attentBonus", attent.getAttentBonus());
			row.put("empWage", attent.getEmpWage());
			row.put("empId", attent.getEmp().getEmpId());
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", hd.attentCount());
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
