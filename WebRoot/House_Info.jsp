<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Biz.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style>
   #all{width:100%;border:0px;height:950px;}
   #top{width:100%;border:0px;color:#FF0000;height:100px;}
   #middle{width:100%;border:0px;height:800px;}
   #down{width:100%;border:0px;height:50px}
  </style>
    <title>房屋详情</title>
  </head>
  
  <body>
     <div id="all">
    <div id="top">
    <strong >欢迎使用租房系统</strong>
    </div>
    <div id="middle">
       <c:forEach var="list" items="${requestScope.list }" varStatus="status">
      <p> ${list.title } </p>
      </c:forEach>
    </div>
    <div id="down">
    
    </div>
    <div id="foot">
    
    </div>
    </div>
  </body>
</html>
