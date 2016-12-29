package org.lanqiao.wuliu.servlet.jurisdiction;

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
import org.lanqiao.wuliu.dao.impl.Jurisdiction;
import org.lanqiao.wuliu.util.FormUtils;

@WebServlet(name = "jurGet", urlPatterns = { "/jurGet" })
public class JurGet extends HttpServlet{
	private static final long serialVersionUID = -7196191995572951821L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int empId = FormUtils.parseInt(request.getParameter("empId"));
		ArrayList<Object[]> lists=new Jurisdiction().getfun(empId);
		JSONArray array = new JSONArray();
		for(Object[] list:lists){
			JSONObject row1=new JSONObject();
			row1.put("empId", list[0]);
			row1.put("funId", list[1]);
			row1.put("funName", list[2]);
			array.put(row1);
		}
		out.println(array);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
