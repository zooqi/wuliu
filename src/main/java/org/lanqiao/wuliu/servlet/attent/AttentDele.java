package org.lanqiao.wuliu.servlet.attent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.service.impl.HRManageServiceImpl;

/**
 * 删除考勤记录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "attentDele", urlPatterns = { "/attentDele" })
public class AttentDele extends HttpServlet {

	private static final long serialVersionUID = -9136859300276646410L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int attentId = Integer.parseInt(request.getParameter("attentId"));
		HRManageServiceImpl hsi = new HRManageServiceImpl();
		if (hsi.attentDele(attentId) == 1) {
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
