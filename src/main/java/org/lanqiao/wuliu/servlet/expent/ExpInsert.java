package org.lanqiao.wuliu.servlet.expent;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.bean.Expent;
import org.lanqiao.wuliu.service.impl.ExpentSerciceImpl;

@WebServlet(name = "expInsert", urlPatterns = { "/expInsert" })
public class ExpInsert extends HttpServlet {

	private static final long serialVersionUID = 6565423736807620828L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String expEmpNum = request.getParameter("expEmpNum");
		String expEmpName = request.getParameter("expEmpName");
		String expFunction = request.getParameter("expFunction");
		double expMoney = 0;
		String a = request.getParameter("expMoney");
		if (a != null && !a.equals("")) {
			expMoney = Double.parseDouble(a);
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date expDate = null;
		String b = request.getParameter("expDate");
		if (b != null && !b.equals("")) {
			try {
				expDate = df.parse(b);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		String expRemark = request.getParameter("expRemark");
		Expent expent = new Expent();

		expent.setExpEmpNum(expEmpNum);
		expent.setExpEmpName(expEmpName);
		expent.setExpFunction(expFunction);
		expent.setExpMoney(expMoney);
		expent.setExpDate(expDate);
		expent.setExpRemark(expRemark);

		ExpentSerciceImpl esi = new ExpentSerciceImpl();

		int num = esi.expInsert(expent);

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
