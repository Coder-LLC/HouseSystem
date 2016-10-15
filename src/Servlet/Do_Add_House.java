package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.HouseBean;
import Biz.HouseBiz;

public class Do_Add_House extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int i=GetInfo(request,response);
		if(i==1){
			out.print("<script>alert('添加房屋信息成功');location='http://localhost:8080/HouseSystem/Index.jsp';</script>");
		}
		out.print("<script>alert('添加房屋信息失败');location='http://localhost:8080/HouseSystem/Add_House.jsp';</script>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}
    
	public int GetInfo(HttpServletRequest request, HttpServletResponse response){
		int i=0;
		HttpSession session=request.getSession();
		String user=(String)(session.getAttribute("user_id"));
		int user_id=Integer.parseInt(user);
		String title=request.getParameter("title");
		int type_id=Integer.parseInt(request.getParameter("type"));
		double floorate=Double.valueOf(request.getParameter("floorate"));
		double price=Double.valueOf(request.getParameter("price"));
		int street_id=Integer.parseInt(request.getParameter("street_id"));
		String contact=request.getParameter("contact");
		String description=request.getParameter("description");
		Date date = new Date();
		HouseBean house=new HouseBean();
		house.setUser_id(user_id);
		house.setTitle(title);
		house.setType_id(type_id);
		house.setFloorate(floorate);
		house.setPrice(price);
		house.setStreet_id(street_id);
		house.setContact(contact);
		house.setDescription(description);
		house.setDate(date);
		HouseBiz hb=new HouseBiz();
		i=hb.AddHouse(house);
		return i;
	}
}
