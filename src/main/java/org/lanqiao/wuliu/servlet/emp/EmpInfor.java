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

@WebServlet(name = "empInfor", urlPatterns = { "/empInfor" })
public class EmpInfor extends HttpServlet {

	private static final long serialVersionUID = -3344382381426516870L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HrDaoImpl hd = new HrDaoImpl();

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ArrayList<Emp> emps = hd.empInfor();

		JSONArray array = new JSONArray();
		for (Emp emp : emps) {
			JSONObject row = new JSONObject();
			row.put("empId", emp.getEmpId());
			row.put("empName", emp.getEmpName());
			row.put("empDepart", emp.getEmpDepart());
			row.put("empNum", emp.getEmpNum());
			array.put(row);
		}
		out.println(array);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
