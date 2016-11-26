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

@WebServlet(name = "expUpdate", urlPatterns = { "/expUpdate" })
public class ExpUpdate extends HttpServlet {

	private static final long serialVersionUID = 6713311893205120371L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String expEmpNum=request.getParameter("expEmpNum");
		String expEmpName=request.getParameter("expEmpName");
		int expId = Integer.parseInt(request.getParameter("expId"));
		//System.out.println(expId);
		String expFunction = request.getParameter("expFunction");
		
		String money=request.getParameter("expMoney");
		double expMoney=0;
		if(!money.equals(null)&&!money.equals("")){
			expMoney = Double.parseDouble(money);
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date expDate = null;
		String c = request.getParameter("expDate");
		if (c != null && !c.equals("")) {
			try {
				expDate = df.parse(c);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		String expRemark = request.getParameter("expRemark");

		Expent exp = new Expent();

		exp.setExpEmpName(expEmpName);
		exp.setExpEmpNum(expEmpNum);
		exp.setExpId(expId);
		exp.setExpFunction(expFunction);
		exp.setExpMoney(expMoney);
		exp.setExpDate(expDate);
		exp.setExpRemark(expRemark);
		
		ExpentSerciceImpl esi = new ExpentSerciceImpl();
		if (esi.expUpdate(exp, expId)==1) {
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
