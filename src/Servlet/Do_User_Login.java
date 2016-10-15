package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Bean.UserBean;
import Biz.UserBiz;

public class Do_User_Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		boolean b=false;
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBean user=new UserBean();
		user.setName(username);
		user.setPassword(password);
		UserBiz ub=new UserBiz();
		b=ub.UserLogin(user);
		if(b){
			HttpSession session=request.getSession();//设置session
			session.setAttribute("user_id", user.getId());
			session.setAttribute("username", user.getName());
			response.sendRedirect("http://localhost:8080/HouseSystem/Index.jsp");
		}
		else{
			out.println("<script>alert('用户名或密码错误，请检查后重试');location='http://localhost:8080/HouseSystem/Index.jsp';</script>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
