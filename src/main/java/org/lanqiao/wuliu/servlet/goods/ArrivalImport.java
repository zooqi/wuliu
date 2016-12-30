package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.dao.impl.TrafficDaoImpl;
import org.lanqiao.wuliu.util.XLSUtils;

/**
 * @author zooqi
 *
 */
@WebServlet(name = "arrivalImport", urlPatterns = { "/arrivalImport" })
public class ArrivalImport extends HttpServlet {

	private static final long serialVersionUID = 6522063190612589199L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 检查表单类型
		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println("{\"success\":false}");
			return;
		}

		int count = 0;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> fileItems = null;
		try {
			fileItems = upload.parseRequest(request);
			if (fileItems.size() == 0) {
				out.println("{\"success\":false}");
				return;
			}

			FileItem item = fileItems.get(0);

			Object[] objects = XLSUtils.importArrival(item.getInputStream(), item.getName());

			Logistics traffic = (Logistics) objects[0];
			List<Goods> list = (List<Goods>) objects[1];
			count = new TrafficDaoImpl().importArrival(traffic, list);
			if (count == 0) {
				out.println("{\"success\":false}");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("{\"success\":false}");
			return;
		} finally {
			fileItems.clear();
		}

		JSONObject json = new JSONObject();
		json.put("success", true);
		json.put("count", count);
		out.println(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
