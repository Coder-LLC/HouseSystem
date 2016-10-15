package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import Biz.UserBiz;

public class Do_User_Register extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String tellphone=request.getParameter("tellphone");
		UserBean user=new UserBean();
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setTellphone(tellphone);
		UserBiz ub=new UserBiz();
		boolean b=false;
		boolean c=false;
		c=ub.CheckRigester(user);
		PrintWriter out = response.getWriter();	
        if(c==true){
        	b=ub.UserRegist(user);
        	if(b){
        		out.println("<script>alert('注册成功');location='http://localhost:8080/HouseSystem/Login.jsp';</script>");
        	}
        	else{
             	out.println("<script>alert('注册失败，请稍后重试');location='http://localhost:8080/HouseSystem/Register.jsp';</script>");
            }
		}
        else{
        	out.println("<script>alert('注册失败,已有用户使用该用户呢称,请换一个重试');location='http://localhost:8080/HouseSystem/Register.jsp';</script>");
        } 
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
