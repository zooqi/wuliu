package org.lanqiao.wuliu.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.service.impl.BusinessManageServiceImpl;
import org.lanqiao.wuliu.util.FormUtils;

/**
 * 更新物流记录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "goodsUpdate", urlPatterns = { "/goodsUpdate" })
public class GoodsUpda extends HttpServlet {

	private static final long serialVersionUID = -9154204721194366236L;

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

		int goId = Integer.parseInt(request.getParameter("goId"));

		Goods goods = new Goods();
		goods.setGoId(goId);
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
		doGet(request, response);
	}

}
