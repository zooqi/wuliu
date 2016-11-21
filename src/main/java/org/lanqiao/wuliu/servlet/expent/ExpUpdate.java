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

import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.bean.Expent;
import org.lanqiao.wuliu.service.impl.ExpentSerciceImpl;

@WebServlet(name = "expUpdate", urlPatterns = { "/expUpdate" })
public class ExpUpdate extends HttpServlet {

	private static final long serialVersionUID = 6713311893205120371L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int expId = Integer.parseInt(request.getParameter("expId"));
		String expFunction = request.getParameter("expFunction");
		double expMoney = Double.parseDouble(request.getParameter("expMoney"));

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
		int empId = Integer.parseInt(request.getParameter("empId"));

		Expent exp = new Expent();
		Emp emp = new Emp();
		exp.setExpId(expId);
		exp.setExpFunction(expFunction);
		exp.setExpMoney(expMoney);
		exp.setExpDate(expDate);
		exp.setExpRemark(expRemark);
		emp.setEmpId(empId);
		exp.setEmp(emp);
		ExpentSerciceImpl esi = new ExpentSerciceImpl();
		if (esi.expUpdate(expId, empId) == 1) {
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
