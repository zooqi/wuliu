package org.lanqiao.wuliu.servlet.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.dao.impl.HrDaoImpl;

@WebServlet(name = "empDelete", urlPatterns = { "/empDelete" })
public class EmpDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int empId = Integer.parseInt(request.getParameter("empId"));
		HrDaoImpl hd = new HrDaoImpl();

		if (hd.empInforDele(empId) == 1) {
			out.println("{\"success\":true}");
		} else {
			out.println("{\"success\":false}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
