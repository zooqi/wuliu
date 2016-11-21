package org.lanqiao.wuliu.servlet.attent;

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

import org.lanqiao.wuliu.bean.Attent;
import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.service.impl.HRManageServiceImpl;

@WebServlet(name = "attentAdd", urlPatterns = { "/attentAdd" })
public class AttentAdd extends HttpServlet {

	private static final long serialVersionUID = -5991516380206664149L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date attentDate = null;
		String a = request.getParameter("attentDate");
		if (a != null && !a.equals("")) {
			try {
				attentDate = df.parse(a);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		String b = request.getParameter("attentNum");
		double attentNum = 0;
		if (b != null && !b.equals("")) {
			attentNum = Double.parseDouble(b);
		}
		String c = request.getParameter("attentReasonNum");
		double attentReasonNum = 0;
		if (c != null && !c.equals("")) {
			attentReasonNum = Double.parseDouble(c);
		}
		String attentReason = request.getParameter("attentReason");
		String d = request.getParameter("attentOverTimeNum");
		double attentOverTimeNum = 0;
		if (d != null && !d.equals("")) {
			attentOverTimeNum = Double.parseDouble(d);
		}
		String e = request.getParameter("attentOverTimePay");
		double attentOverTimePay = 0;
		if (e != null && !e.equals("")) {
			attentOverTimePay = Double.parseDouble(e);
		}
		String f = request.getParameter("attentBonus");
		double attentBonus = 0;
		if (f != null && !f.equals("")) {
			attentBonus = Double.parseDouble(f);
		}
		String attentRemark = request.getParameter("attentRemark");
		int empId = Integer.parseInt(request.getParameter("empName"));

		Attent attent = new Attent();
		Emp emp = new Emp();
		emp.setEmpId(empId);
		attent.setEmp(emp);
		attent.setAttentDate(attentDate);
		attent.setAttentNum(attentNum);
		attent.setAttentReasonNum(attentReasonNum);
		attent.setAttentReason(attentReason);
		attent.setAttentOverTimeNum(attentOverTimeNum);
		attent.setAttentOverTimePay(attentOverTimePay);
		attent.setAttentBonus(attentBonus);
		attent.setAttentRemark(attentRemark);

		HRManageServiceImpl hsi = new HRManageServiceImpl();

		int num = hsi.attentInsert(attent, empId);
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
