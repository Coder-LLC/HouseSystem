<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Biz.UserBiz" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <style type="text/css">
      #head{width:100%;border:0px;color:#FF0000;height:100px;}
      #main{height:300px;border:0px;width:100%;}
      #foot{height:50px;border:0px;width:100%;}
    </style>
    <title>用户中心</title>
  </head>
  
  <body>
    <%
      String user=session.getAttribute("user_id").toString();
      if(user==null){
    	  out.print("<script> alert('您未登陆，请登陆后重试');location='Login.jsp';</script>");
      }
      else{
          int user_id=Integer.parseInt(user);
          String number=request.getParameter("pageNumber");
          if(number==null||number.equals("")){
          number="1";
          } 
          int pagenumber=Integer.parseInt(number); 
          UserBiz ub=new UserBiz();
          int count=ub.getUserHouseCount(user_id);
          request.setAttribute("count", count);
          int size=3;//每页显示条数
          int totalpage=count/size;
          if(count%size!=0){
	          totalpage++;
          }
          int start=0; 
          start=(pagenumber-1)*size;
          List list=ub.GetUserHouse(user_id, start, size);
          request.setAttribute("list", list);    
      }
    %>
    <div id="head">
      <table width="100%" height="100%">
        <tr>
          <td width="100%" height="100%"><strong>欢迎使用租房系统</strong></td>
        </tr>
      </table>
    </div>
    
    <div id="main">
      ${sessionScope.username }
      <c:forEach var="list" items="${requestScope.list }" varStatus="status">
        <p> <a href="servlet/House_Info?id=${list.id }" >${list.title }</a> </p>
      </c:forEach>
      <form name="page" method="post" action="User_Center.jsp">                    
                         页码: 
        <select name="pageNumber">         
          <c:forEach var="count" items="${requestScope.count }" begin="1" end="${count }">
          <option> 
            ${count }
          </option>  
          </c:forEach>
        </select> 
       <input type="submit"name="button"value="跳转" />      
      </form>       
    </div>
    
    <div id="foot">
      <hr/>
      <center>
        <p><a href="Index.jsp">租房系统</a></p>
      </center>
    </div>
  </body>
</html>
