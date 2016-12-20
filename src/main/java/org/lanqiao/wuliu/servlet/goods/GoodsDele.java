package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.service.impl.BusinessManageServiceImpl;

/**
 * 删除物流记录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "goodsDelete", urlPatterns = { "/goodsDelete" })
public class GoodsDele extends HttpServlet {

	private static final long serialVersionUID = 348991134876831692L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int goId = Integer.parseInt(request.getParameter("goId"));

		BusinessManageServiceImpl bms = new BusinessManageServiceImpl();

		if (bms.goDele(goId) == 1) {
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
