package org.lanqiao.wuliu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.wuliu.bean.Emp;
import org.lanqiao.wuliu.bean.Menu;
import org.lanqiao.wuliu.bean.Role;
import org.lanqiao.wuliu.dao.impl.CommDaoImpl;

/**
 * 登录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {

	CommDaoImpl cdi = new CommDaoImpl();
	private static final long serialVersionUID = 8504807255726048469L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String logNum = request.getParameter("logNum");
		String logPasswd = request.getParameter("logPasswd");

		String auto = request.getParameter("auto");

		Emp emp = new Emp();
		emp.setEmpNum(logNum);
		emp.setEmpPasswd(logPasswd);

		CommDaoImpl cdi = new CommDaoImpl();
		Emp compare = cdi.login(emp);
		if (compare.getEmpNum() != null) {
			if (compare.getEmpPasswd().equals(emp.getEmpPasswd())) {
				// 登录成功
				HttpSession session = request.getSession();
				session.setAttribute("emp", emp);

				if (auto != null && !auto.equals("")) {
					if (auto.equals("yes")) {
						Cookie cookieLogNum = new Cookie("logNum", logNum);
						Cookie cookieLogPasswd = new Cookie("logPasswd", logPasswd);
						cookieLogNum.setMaxAge(12 * 3600);
						cookieLogPasswd.setMaxAge(12 * 3600);
						response.addCookie(cookieLogNum);
						response.addCookie(cookieLogPasswd);
					}
				}

				ArrayList<Role> roles = cdi.getRoleId(emp.getEmpNum());
				List<ArrayList<Menu>> lists = new ArrayList<ArrayList<Menu>>();
				for (Role role : roles) {
					ArrayList<Menu> menus = cdi.getMenus(role.getRoleId());
					lists.add(menus);
				}
				request.setAttribute("roles", roles);
				request.setAttribute("lists", lists);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				// 密码错误
				request.setAttribute("error1", "账号或密码错误，请重新输入");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			// 职工号不存在
			request.setAttribute("error2", "账号不存在，请重新输入");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
