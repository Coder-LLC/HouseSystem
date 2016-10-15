package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Biz.DistrictBiz;
import Biz.HouseBiz;
import Biz.StreetBiz;
import Biz.TypeBiz;

public class Modify_House extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		HouseBiz hb=new HouseBiz();
		DistrictBiz db=new DistrictBiz();
		TypeBiz tb=new TypeBiz();
		StreetBiz sb=new StreetBiz();
		List list1=hb.GetHouseById(id);
		List list2=db.GetDistrict();
		List list3=tb.GetType();
		List list4=sb.GetAllStreet();
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		request.getRequestDispatcher("/Modify_House.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request,response);
	}

}
