package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.dao.impl.BusinessManage;
import org.lanqiao.wuliu.util.FormUtils;

/**
 * 添加物流记录
 * 
 * @author zooqi
 *
 */
@WebServlet(name = "goodsAdd", urlPatterns = { "/goodsAdd" })
public class GoodsAdd extends HttpServlet {

	private static final long serialVersionUID = 8672778332159400410L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String goBank = request.getParameter("goBank");
		String goSiteEnd = request.getParameter("goSiteEnd");
		String goForMan = request.getParameter("goForMan");
		String goForPhone = request.getParameter("goForPhone");
		String goForAddress = request.getParameter("goForAddress");
		String goSendMan = request.getParameter("goSendMan");
		String goSendPhone = request.getParameter("goSendPhone");
		String goSendAddress = request.getParameter("goSendAddress");

		String goName = request.getParameter("goName");
		int goNum = FormUtils.parseInt(request.getParameter("goNum"));
		String goPack = request.getParameter("goPack");
		double goWeight = FormUtils.parseDouble(request.getParameter("goWeight"));
		double goVolume = FormUtils.parseDouble(request.getParameter("goVolume"));

		double goPay = FormUtils.parseDouble(request.getParameter("goPay"));
		double goInsurancePay = FormUtils.parseDouble(request.getParameter("goInsurancePay"));
		double goReplacePay = FormUtils.parseDouble(request.getParameter("goReplacePay"));
		double goCommission = FormUtils.parseDouble(request.getParameter("goCommission"));
		double goDamagePay = FormUtils.parseDouble(request.getParameter("goDamagePay"));
		double goTransitPay = FormUtils.parseDouble(request.getParameter("goTransitPay"));

		String goGetWay = request.getParameter("goGetWay");
		String goPayWay = request.getParameter("goPayWay");
		String goRemark = request.getParameter("goRemark");
		int goType = FormUtils.parseInt(request.getParameter("goType"));

		int logId = FormUtils.parseInt(request.getParameter("logId"));

		Goods goods = new Goods();
		goods.setGoBank(goBank);
		goods.setGoSiteEnd(goSiteEnd);
		goods.setGoForMan(goForMan);
		goods.setGoForPhone(goForPhone);
		goods.setGoForAddress(goForAddress);
		goods.setGoSendMan(goSendMan);
		goods.setGoSendPhone(goSendPhone);
		goods.setGoSendAddress(goSendAddress);
		goods.setGoName(goName);
		goods.setGoNum(goNum);
		goods.setGoPack(goPack);
		goods.setGoWeight(goWeight);
		goods.setGoVolume(goVolume);
		goods.setGoPay(goPay);
		goods.setGoInsurancePay(goInsurancePay);
		goods.setGoReplacePay(goReplacePay);
		goods.setGoCommission(goCommission);
		goods.setGoDamagePay(goDamagePay);
		goods.setGoTransitPay(goTransitPay);
		goods.setGoGetWay(goGetWay);
		goods.setGoPayWay(goPayWay);
		goods.setGoRemark(goRemark);
		goods.setGoType(goType);

		BusinessManage dao = new BusinessManage();
		int count = dao.goAdd(goods, logId);
		if (count == 1) {
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
