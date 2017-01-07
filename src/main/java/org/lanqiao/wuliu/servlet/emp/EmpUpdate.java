package org.lanqiao.wuliu.servlet.emp;

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
import org.lanqiao.wuliu.dao.impl.HrDaoImpl;

@WebServlet(name = "empUpdate", urlPatterns = { "/empUpdate" })
public class EmpUpdate extends HttpServlet {

	private static final long serialVersionUID = -1731303218025310740L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String empNum = request.getParameter("empNum");
		String empName = request.getParameter("empName");
		String empDepart = request.getParameter("empDepart");
		String empPosition = request.getParameter("empPosition");
		String a = request.getParameter("empWage");
		double empWage = 0;
		if (a != null && !a.equals("")) {
			empWage = Double.parseDouble(a);
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date empDate = null;
		String c = request.getParameter("empDate");
		if (c != null && !c.equals("")) {
			try {
				empDate = df.parse(c);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		String empEdu = request.getParameter("empEdu");
		String empSex = request.getParameter("empSex");
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		Date empBorn = null;
		String b = request.getParameter("empBorn");
		if (b != null && !b.equals("")) {
			try {
				empBorn = df1.parse(b);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		String empPhone = request.getParameter("empPhone");
		String empQQ = request.getParameter("empQQ");
		String empAddress = request.getParameter("empAddress");
		String empHealth = request.getParameter("empHealth");
		String empMarriage = request.getParameter("empMarriage");
		String empPasswd = request.getParameter("empPasswd");
		int empId = Integer.parseInt(request.getParameter("empId"));

		Emp emp = new Emp();

		emp.setEmpNum(empNum);
		emp.setEmpName(empName);
		emp.setEmpSex(empSex);
		emp.setEmpDepart(empDepart);
		emp.setEmpPosition(empPosition);
		emp.setEmpWage(empWage);
		emp.setEmpDate(empDate);
		emp.setEmpEdu(empEdu);
		emp.setEmpBorn(empBorn);
		emp.setEmpHealth(empHealth);
		emp.setEmpMarriage(empMarriage);
		emp.setEmpPhone(empPhone);
		emp.setEmpQQ(empQQ);
		emp.setEmpPasswd(empPasswd);
		emp.setEmpAddress(empAddress);

		HrDaoImpl hd = new HrDaoImpl();
		if (hd.empInforUpda(emp, empId) == 1) {
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
