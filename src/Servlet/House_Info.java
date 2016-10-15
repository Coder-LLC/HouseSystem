package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Biz.HouseBiz;

public class House_Info extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;;charset=UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		HouseBiz hb=new HouseBiz();
		List list=hb.GetHouseById(id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/House_Info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
