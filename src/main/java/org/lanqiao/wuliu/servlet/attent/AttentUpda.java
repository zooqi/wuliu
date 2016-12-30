package org.lanqiao.wuliu.servlet.attent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.bean.Attent;
import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.dao.impl.HRManageDao;
import org.lanqiao.wuliu.service.impl.HRManageServiceImpl;
import org.lanqiao.wuliu.util.ParseUtils;

@WebServlet(name = "attentUpda", urlPatterns = { "/attentUpda" })
public class AttentUpda extends HttpServlet {

	private static final long serialVersionUID = -7269441136942687690L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String empName=request.getParameter("empName");
		String attentDate = request.getParameter("attentDate");
		double attentNum = ParseUtils.parseDouble(request.getParameter("attentNum"));
		double attentReasonNum = ParseUtils.parseDouble(request.getParameter("attentReasonNum"));
		String attentReason = request.getParameter("attentReason");
		double attentOverTimeNum = ParseUtils.parseDouble(request.getParameter("attentOverTimeNum"));
		double attentOverTimePay = ParseUtils.parseDouble(request.getParameter("attentOverTimePay"));
		double attentBonus = ParseUtils.parseDouble(request.getParameter("attentBonus"));
		String attentRemark = request.getParameter("attentRemark");
		int empId = ParseUtils.parseInt(request.getParameter("empName"));
		int attentId=ParseUtils.parseInt(request.getParameter("attentId"));
		
		Attent attent = new Attent();
		Emp emp = new Emp();
		emp.setEmpName(empName);
		attent.setEmp(emp);
		attent.setAttentDate(attentDate);
		attent.setAttentNum(attentNum);
		attent.setAttentReasonNum(attentReasonNum);
		attent.setAttentReason(attentReason);
		attent.setAttentOverTimeNum(attentOverTimeNum);
		attent.setAttentOverTimePay(attentOverTimePay);
		attent.setAttentBonus(attentBonus);
		attent.setAttentRemark(attentRemark);
		attent.setAttentId(attentId);

		HRManageDao hd=new HRManageDao();
		
		if (hd.attentUpda(attent, attentId) == 1) {
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
