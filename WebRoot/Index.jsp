<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <style>
      #all{width:100%;border:0px;height:950px;}
      #top{width:100%;border:0px;color:#FF0000;height:100px;}
      #inner{width:10%;border:0px;height:30px;float:right;position:relative;bottom:-50px;}
      #middle{width:100%;border:0px;height:800px;}
      #down{width:100%;border:0px;height:50px}
      #foot{width:100%;border:0px;height:20px}
    </style>
   
    <title>租房系统主页</title>   
  </head>  
  <body>   
    <sx:head/>
    
    <div id="all">
    
      <div id="top">
        <strong >欢迎使用租房系统</strong>
        <div id="inner">
          <s:div cssClass="login" id="login">
            <s:a href="Register.jsp">注册</s:a>
            <s:a href="Login.jsp"> 登陆 </s:a>  
          </s:div>
        </div>
        
      </div>
      
    <div id="middle">    
      <c:forEach var="list" items="${requestScope.list }" varStatus="status">
        <p> <a href="ReadHouse.action?id=${list.id }" >${list.title }</a> </p>
      </c:forEach>
      <form name="page" method="post" action="index.action">                    
                       页码: 
        <select name="pageNumber">    
       <%  
         if(request.getAttribute("totalpage")==null){
     	    //response.sendRedirect("index.action");
     	    request.getRequestDispatcher("index.action").forward(request, response);
         }
         else{
            int i=1;   
            int totalpage=Integer.parseInt(request.getAttribute("totalpage").toString());
            for( i = 1;i <= totalpage;i++) {
       %>
         <option> 
          <%=i%> 
         </option>  
          <%}%>
       <%}%>
        </select> 
       <input type="submit"name="button"value="跳转" />      
      </form>       
    </div>
    
    <div id="down">
    
    </div>
    
    <div id="foot">
      <hr/>
      <center>
        <p> <a href="Index.jsp">租房系统</a> <a href="User_Center.jsp">用户中心</a> </p>
      </center>
    </div>  
    
    </div>
  </body>
</html>
