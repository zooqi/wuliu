package org.lanqiao.wuliu.servlet.jurisdiction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.dao.impl.Jurisdiction;

@WebServlet(name = "jurReach", urlPatterns = { "/jurReach" })
public class JurReach {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String empNum=request.getParameter("empNum");
		String empName=request.getParameter("empName");
		String empDepart=request.getParameter("empDepart");
		Emp emp=new Emp();
		emp.setEmpNum(empNum);
		emp.setEmpName(empName);
		emp.setEmpDepart(empDepart);
		ArrayList<Object[]> lists=new Jurisdiction().selectJur(emp);
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(Object[] list:lists){
			JSONObject row = new JSONObject();
			row.put("menuId",list[0]);
			row.put("menuName",list[1]);
			row.put("funId",list[2]);
			row.put("funName",list[3]);
			array.put(row);
		}
		json.put("rows", array);
		out.println(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
