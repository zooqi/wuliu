package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.service.impl.BusinessManageServiceImpl;

/**
 * 查找物流记录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "goodsReach", urlPatterns = { "/goodsReach" })
public class GoodsReach extends HttpServlet {

	private static final long serialVersionUID = -4742707004844364472L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int rowsPerPage = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));

		String logCarLicence = request.getParameter("logCarLicence");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date logSendDate = null;
		String a = request.getParameter("logSendDate");
		if (a != null && !a.equals("")) {
			try {
				logSendDate = df.parse(a);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Logistics logistics = new Logistics();
		Goods goodsReach = new Goods();
		logistics.setLogCarLicence(logCarLicence);
		logistics.setLogSendDate(logSendDate);
		goodsReach.setLogistics(logistics);

		BusinessManageServiceImpl bms = new BusinessManageServiceImpl();
		ArrayList<Goods> goods = bms.goReach((page - 1) * rowsPerPage, rowsPerPage, goodsReach);
		JSONObject json = new JSONObject();
		JSONArray arry1 = new JSONArray();
		for (Goods good : goods) {
			JSONObject row = new JSONObject();
			row.put("goId", good.getGoId());
			row.put("goBank", good.getGoBank());
			row.put("goName", good.getGoName());
			row.put("goNum", good.getGoNum());
			row.put("goPack", good.getGoPack());
			row.put("goWeight", good.getGoweight());
			row.put("goVolume", good.getGoVolume());
			row.put("goSendMan", good.getGoSendMan());
			row.put("goSendPhone", good.getGoSendPhone());
			row.put("goSendAddress", good.getGoSendAddress());
			row.put("goForMan", good.getGoForMan());
			row.put("goForPhone", good.getGoForPhone());
			row.put("goForAddress", good.getGoForAddress());
			row.put("goGetWay", good.getGoGetWay());
			row.put("goPayWay", good.getGoPayWay());
			row.put("goPay", good.getGoPay());
			row.put("goInsurancePay", good.getGoInsurancePay());
			row.put("goReplacePay", good.getGoReplacePay());
			row.put("goCommission", good.getGoCommission());
			row.put("goDamagePay", good.getGoDamagePay());

			row.put("goTransitPay", good.getGoTransitPay());

			row.put("goSiteEnd", good.getGoSiteEnd());
			row.put("goRemark", good.getGoRemark());
			// row.put("logId", good.getLogistics().getLogId());

			arry1.put(row);

		}
		json.put("rows", arry1);

		json.put("total", bms.goConut());
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
