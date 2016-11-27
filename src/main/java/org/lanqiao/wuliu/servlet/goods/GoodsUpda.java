package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.service.impl.BusinessManageServiceImpl;

/**
 * 更新物流记录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "goodsUpda", urlPatterns = { "/goodsUpda" })
public class GoodsUpda extends HttpServlet {

	private static final long serialVersionUID = -9154204721194366236L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String goBank = request.getParameter("goBank");
		String goName = request.getParameter("goName");
		int goNum = Integer.parseInt(request.getParameter("goNum"));
		String goPack = request.getParameter("goPack");
		String a = request.getParameter("goWeight");
		double goWeight = 0;
		if (a != null && a.equals("")) {
			goWeight = Double.parseDouble(a);
		}
		String b = request.getParameter("goVolume");
		double goVolume = 0;
		if (b != null && b.equals("")) {
			goVolume = Double.parseDouble(b);
		}
		String goSendMan = request.getParameter("goSendMan");
		String goSendPhone = request.getParameter("goSendPhone");
		String goSendAddress = request.getParameter("goSendAddress");
		String goForMan = request.getParameter("goForMan");
		String goForPhone = request.getParameter("goForPhone");
		String goForAddress = request.getParameter("goForAddress");
		String goGetWay = request.getParameter("goGetWay");
		String goPayWay = request.getParameter("goPayWay");
		String c = request.getParameter("goPay");
		double goPay = 0;
		if (c != null && c.equals("")) {
			goPay = Double.parseDouble(c);
		}
		String d = request.getParameter("goInsurancePay");
		double goInsurancePay = 0;
		if (d != null && d.equals("")) {
			goInsurancePay = Double.parseDouble(d);
		}
		String e = request.getParameter("gReplacePay");
		double goReplacePay = 0;
		if (e != null && e.equals("")) {
			goReplacePay = Double.parseDouble(e);
		}
		String f = request.getParameter("goCommission");
		double goCommission = 0;
		if (f != null && f.equals("")) {
			goCommission = Double.parseDouble(f);
		}
		String h = request.getParameter("goDamagePay");
		double goDamagePay = 0;
		if (h != null && h.equals("")) {
			goDamagePay = Double.parseDouble(h);
		}
		// String goMessage = request.getParameter("goMessage");
		String k = request.getParameter("goTransitPay");
		double goTransitPay = 0;
		if (k != null && k.equals("")) {
			goTransitPay = Double.parseDouble(k);
		}
		// String goSiteStart = request.getParameter("goSiteStart");
		String goSiteEnd = request.getParameter("goSiteEnd");
		String goRemark = request.getParameter("goRemark");
		int logId = Integer.parseInt(request.getParameter("logId"));
		int goId = Integer.parseInt(request.getParameter("goId"));

		Goods goods = new Goods();
		goods.setGoBank(goBank);
		goods.setGoName(goName);
		goods.setGoNum(goNum);
		goods.setGoPack(goPack);
		goods.setGoWeight(goWeight);
		goods.setGoVolume(goVolume);
		goods.setGoSendMan(goSendMan);
		goods.setGoSendPhone(goSendPhone);
		goods.setGoSendAddress(goSendAddress);
		goods.setGoForMan(goForMan);
		goods.setGoForPhone(goForPhone);
		goods.setGoForAddress(goForAddress);
		goods.setGoGetWay(goGetWay);
		goods.setGoPayWay(goPayWay);
		goods.setGoPay(goPay);
		goods.setGoInsurancePay(goInsurancePay);
		goods.setGoReplacePay(goReplacePay);
		goods.setGoCommission(goCommission);
		goods.setGoDamagePay(goDamagePay);
		goods.setGoTransitPay(goTransitPay);
		goods.setGoSiteEnd(goSiteEnd);
		goods.setGoRemark(goRemark);
		goods.setGoId(goId);
		Logistics log = new Logistics();
		log.setLogId(logId);
		goods.setLogistics(log);

		BusinessManageServiceImpl bms = new BusinessManageServiceImpl();
		int num = bms.goUpda(goods, goId);
		if (num == 1) {
			out.println("{\"success\":true}");
		} else {
			out.println("{\"success\":false}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
