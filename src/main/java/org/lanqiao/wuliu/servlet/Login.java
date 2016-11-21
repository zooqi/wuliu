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
import org.lanqiao.wuliu.service.impl.CommServiceImpl;

/**
 * 登录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {

	CommServiceImpl csi = new CommServiceImpl();
	private static final long serialVersionUID = 8504807255726048469L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String logNum = request.getParameter("logNum");
		String logPasswd = request.getParameter("logPasswd");

		String auto = request.getParameter("auto");

		Emp emp = new Emp();
		emp.setEmpNum(logNum);
		emp.setEmpPasswd(logPasswd);

		int compare = csi.login(emp);

		if (compare != 0) {
			if (compare == 1) {
				request.setAttribute("error1", "账号或密码错误，请重新输入");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else if (compare == 2) {
				request.setAttribute("error2", "账号不存在，请重新输入");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
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

			ArrayList<Role> roles = csi.getRoleId(emp.getEmpNum());
			List<ArrayList<Menu>> lists = new ArrayList<ArrayList<Menu>>();
			for (Role role : roles) {
				ArrayList<Menu> menus = csi.getMenus(role.getRoleId());
				lists.add(menus);
			}
			request.setAttribute("roles", roles);
			request.setAttribute("lists", lists);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
