package org.lanqiao.wuliu.servlet.expent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.service.impl.ExpentSerciceImpl;
import org.lanqiao.wuliu.util.ParseUtils;

@WebServlet(name = "expDelete", urlPatterns = { "/expDelete" })
public class ExpDelete extends HttpServlet {

	private static final long serialVersionUID = 8865762877770228329L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int expId = ParseUtils.parseInt(request.getParameter("expId"));

		ExpentSerciceImpl exi = new ExpentSerciceImpl();

		if (exi.expDelete(expId) == 1) {
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
