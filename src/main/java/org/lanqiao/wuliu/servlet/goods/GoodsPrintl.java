package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "goodsPrintl", urlPatterns = { "/goodsPrintl" })
public class GoodsPrintl extends HttpServlet {

	private static final long serialVersionUID = 8671828661913193151L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String row = request.getParameter("row");
		HttpSession session = request.getSession();
		session.setAttribute("row", row);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
