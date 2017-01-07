package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.dao.impl.BusinessDaoImpl;

/**
 * 删除物流记录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "goodsDelete", urlPatterns = { "/goodsDelete" })
public class GoodsDelete extends HttpServlet {

	private static final long serialVersionUID = 348991134876831692L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String params = request.getParameter("params");
		JSONArray array = new JSONArray(params);
		List<Integer> ids = new LinkedList<Integer>();
		for (Object object : array) {
			JSONObject json = (JSONObject) object;
			ids.add(json.getInt("goId"));
		}
		BusinessDaoImpl dao = new BusinessDaoImpl();

		if (dao.goBatchDelete(ids) == ids.size()) {
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
