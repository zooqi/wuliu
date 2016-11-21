package org.lanqiao.wuliu.servlet.logistics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 数据导入
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "logistics", urlPatterns = { "/logistics" })
public class Logistics extends HttpServlet {

	private static final long serialVersionUID = 530534238983311971L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileName = request.getParameter("");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
