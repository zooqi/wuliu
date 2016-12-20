package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
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

		// 分页参数、发、到货类型
		int goType;
		int currentPage;
		int rowsPerPage;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
			rowsPerPage = Integer.parseInt(request.getParameter("rows"));
			goType = Integer.parseInt(request.getParameter("goType"));
		} catch (Exception e) {
			return;
		}

		String logCarLicence = request.getParameter("logCarLicence");

		// 验证日期
		String logSendDate = request.getParameter("logSendDate");
		if (logSendDate != null && !logSendDate.equals("")) {
			try {
				new SimpleDateFormat("yyyy-MM-dd").parse(logSendDate);
			} catch (Exception e) {
				return;
			}
		}

		BusinessManageServiceImpl bms = new BusinessManageServiceImpl();
		ArrayList<Goods> goods = bms.goReach(goType, currentPage, rowsPerPage, logCarLicence, logSendDate);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Goods good : goods) {
			JSONObject row = new JSONObject();
			row.put("goId", good.getGoId());
			row.put("goBank", good.getGoBank());
			row.put("goName", good.getGoName());
			row.put("goNum", good.getGoNum());
			row.put("goPack", good.getGoPack());
			row.put("goWeight", good.getGoWeight());
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
			row.put("goType", good.getGoType());
			row.put("logId", good.getLogistics().getLogId());

			Date date = good.getLogistics().getLogSendDate();
			row.put("logSendDate", (date == null) ? "" : new SimpleDateFormat("yyyy-MM-dd").format(date));
			row.put("logCarLicense", good.getLogistics().getLogCarLicence());
			row.put("logCarDriver", good.getLogistics().getLogCarDriver());
			row.put("logContractNum", good.getLogistics().getLogContractNum());
			row.put("logSiteStart", good.getLogistics().getLogSiteStart());
			row.put("logSiteEnd", good.getLogistics().getLogSiteEnd());
			array.put(row);
		}
		json.put("rows", array);
		json.put("total", goods.size());
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
