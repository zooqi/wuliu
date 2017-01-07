package org.lanqiao.wuliu.servlet.emp;

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
import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.dao.impl.HrDaoImpl;

@WebServlet(name = "empReach", urlPatterns = { "/empReach" })
public class EmpReach extends HttpServlet {

	private static final long serialVersionUID = 4325177896183407475L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int rowsPerPage = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));

		Emp searchEmp = new Emp();
		String empNum = request.getParameter("empNum");
		String empName = request.getParameter("empName");
		String empDepart = request.getParameter("empDepart");
		String empSex = request.getParameter("empSex");
		searchEmp.setEmpNum(empNum);
		searchEmp.setEmpName(empName);
		searchEmp.setEmpDepart(empDepart);
		searchEmp.setEmpSex(empSex);

		HrDaoImpl hd = new HrDaoImpl();
		ArrayList<Emp> emps = hd.empInforSel((page - 1) * rowsPerPage, rowsPerPage, searchEmp);

		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Emp emp : emps) {
			JSONObject row = new JSONObject();
			row.put("empNum", emp.getEmpNum());
			row.put("empName", emp.getEmpName());
			row.put("empDepart", emp.getEmpDepart());
			row.put("empPosition", emp.getEmpPosition());
			row.put("empWage", emp.getEmpWage());
			row.put("empDate", emp.getEmpDate());
			row.put("empEdu", emp.getEmpEdu());
			row.put("empSex", emp.getEmpSex());
			row.put("empBorn", emp.getEmpBorn());
			row.put("empPhone", emp.getEmpPhone());
			row.put("empQQ", emp.getEmpQQ());
			row.put("empHealth", emp.getEmpHealth());
			row.put("empMarriage", emp.getEmpMarriage());
			row.put("empAddress", emp.getEmpAddress());
			row.put("empId", emp.getEmpId());
			row.put("empRemark", emp.getEmpRemark());
			row.put("empPasswd", emp.getEmpPasswd());
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", hd.empCount());
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
