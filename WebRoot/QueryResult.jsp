<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
      #head{width:100%;border:0px;color:#FF0000;height:100px;}
      #main{height:300px;border:0px;width:100%;}
      #foot{height:50px;border:0px;width:100%;}
    </style>
    
    <title>查询结果</title>
   
  </head>
  
  <body>
    <div id="head">
      <table width="100%" height="100%">
        <tr>
          <td width="100%" height="100%"><strong >欢迎使用租房系统</strong></td>
        </tr>
      </table>
    </div>
    
    <div id="main">
      <c:forEach var="list" items="${requestScope.list }" varStatus="status">
        <p> <a href="ReadHouse.action?id=${list.id }">${list.title }</a> </p>
      </c:forEach>
      ${list2 }
    </div>
    
    <div id="foot">
      <hr/>
      <center>
        <p><a href="Index.jsp">租房系统</a></p>
      </center>
    </div>
  </body>
</html>
