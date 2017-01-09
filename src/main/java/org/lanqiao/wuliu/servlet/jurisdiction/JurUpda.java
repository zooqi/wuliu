package org.lanqiao.wuliu.servlet.jurisdiction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.dao.impl.JurisdictionDaoImpl;
import org.lanqiao.wuliu.util.ParseUtils;

@WebServlet(name = "jurUpda", urlPatterns = { "/jurUpda" })
public class JurUpda extends HttpServlet {
	private static final long serialVersionUID = -7591453135614960655L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		JurisdictionDaoImpl jdi = new JurisdictionDaoImpl();

		int empId = ParseUtils.parseInt(request.getParameter("empId"));
		String[] funIds = request.getParameterValues("checkbox");
		ArrayList<Integer> lists = jdi.getFuns(empId);
		for(Integer list:lists){
			
			jdi.deleJur(empId, list);
			
		}
		for (String funIda : funIds) {
			int funId = ParseUtils.parseInt(funIda);
			jdi.updateJur(empId, funId);
		}
		out.println("{\"success\":true}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
