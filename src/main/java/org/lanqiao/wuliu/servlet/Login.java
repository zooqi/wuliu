package org.lanqiao.wuliu.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.wuliu.bean.Menu;
import org.lanqiao.wuliu.dao.impl.CommDaoImpl;
import org.lanqiao.wuliu.util.ParseUtils;

/**
 * 登录
 * 
 * @author 杨明静
 *
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {

	private static final long serialVersionUID = 8504807255726048469L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empNum = ParseUtils.toLegalString(request.getParameter("logNum"));
		String empPasswd = ParseUtils.toLegalString(request.getParameter("logPasswd"));
		String auto = ParseUtils.toLegalString(request.getParameter("auto"));

		CommDaoImpl cdi = new CommDaoImpl();
		int status = cdi.login(empNum, empPasswd);

		if (status == -2) {
			request.setAttribute("error2", "账号不存在, 请重新输入");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if (status == -1) {
			request.setAttribute("error1", "密码错误, 请重新输入");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		if (auto.equals("yes")) {
			Cookie cookieLogNum = new Cookie("logNum", empNum);
			Cookie cookieLogPasswd = new Cookie("logPasswd", empPasswd);
			cookieLogNum.setMaxAge(12 * 3600);
			cookieLogPasswd.setMaxAge(12 * 3600);
			response.addCookie(cookieLogNum);
			response.addCookie(cookieLogPasswd);
		}

		Set<Menu> menus = cdi.getMenus(status);
		request.setAttribute("menus", menus);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
