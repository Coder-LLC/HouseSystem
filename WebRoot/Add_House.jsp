<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <style type="text/css">
   #head{width:100%;border:0px;color:#FF0000;height:100px;}
   #main{height:400px;border:0px;width:100%;}
   #foot{height:50px;border:0px;width:100%;}
   </style>
   <title>添加房屋信息</title>
   <script type="text/javascript">
    function check(){
	  if(document.info.title.value==""){
		  alert("标题不能为空");
		  return false;
	  }
	  if(document.getElementsByName("type_id")[0].value==""){
		  alert("房屋类型不能为空");
		  return false;
	  }	  
	  if(document.info.floorate.value==""){
		  alert("面积不能为空");
		  return false;
	  }	  
	  if(document.info.price.value==""){
		  alert("价格不能为空");
		  return false;
      }	  
	  if(document.getElementsByName("district_id")[0].value==""){
		  alert("区域不能为空");
		  return false;
	  }  
	  if(document.getElementsByName("street_id")[0].value==""){
		  alert("街道不能为空");
		  return false;
	  }
	  if(document.info.contact.value==""){
		  alert("联系方式不能为空");
		  return false;
      } 
	  if(document.info.description.value==""){
		  alert("房屋描述不能为空");
		  return false;
      }
	//  if(document.info.house_date.value==""){
		//  alert("房产证日期不能为空");
		 // return false;
     // }
    }
    
    var XMLHttp;
    function createXMLRequest(){  //创建XMLHttpRequest对象
      if(window.XMLHttpRequest){
         XMLHttp=new XMLHttpRequest();
      }
      else if(window.ActiveObject){
         XMLHttp=new ActiveObject("Microsoft.XMLHTTP");
      }
    }
    
    function doAjax(){
    	createXMLRequest();
    	if(XMLHttp!=null){
    	  var district_id=document.getElementById("district_id").value;	
    	  XMLHttp.open("GET", "servlet/Get_Street_By_District_Id?district_id="+district_id, true);
    	  XMLHttp.onreadystatechange=back;
    	  XMLHttp.send(null);
    	}
    	else{
    	  alert("不能创建XMLHttpRequest对象实例");
    	}
    }
    
    function back(){
    	if(XMLHttp.readyState==4){
    	  if(XMLHttp.status==200){
    		  var List=XMLHttp.responseText;
    		  
    	  }
        }
    }
   </script>
  </head>
     <%
       if(request.getAttribute("flag")==null){
    	   request.getRequestDispatcher("Add_house.action").forward(request, response);
       }
     %>
  <body>
    <div id="head">
      <table width="100%" height="100%">
      <tr>
        <td width="100%" height="100%"><strong >欢迎使用租房系统</strong></td>
      </tr>
      </table>
    </div>
    <div id="main">
      <center>
      <form name="info" action="house.action" method="post" onsubmit="return check()">
        <p> 标题：<input type="text" name="title"> </p>
        <p> 
                               请选择房屋类型：
          <select name="type_id">
            <c:forEach var="list1" items="${requestScope.list1 }" varStatus="Status">
              <option value="${list1.id }">
                ${list1.name }
              </option>
            </c:forEach>  
          </select> 
        </p>
        <p> 房屋面积:<input type="text" name="floorate"> </p>
        <p> 房屋价格:<input type="text" name="price"> </p>
        <p>
                           区:
          <select name="district_id" onclick=>
            <c:forEach var="list2" items="${requestScope.list2 }" varStatus="Status">
              <option value="${list2.id }">
                ${list2.name }
              </option>
            </c:forEach>   
          </select>
                        街道:
          <select name="street_id">
            <c:forEach var="list3" items="${requestScope.list3 }" varStatus="Status">
              <option value="${list3.id }">
                ${list3.name }
              </option>
            </c:forEach>  
          </select>
       </p>
          <p> 联系方式:<input type="text" name="contact"> </p>
          <p> 房屋描述:<textarea name="description" rows="5" cols="60"></textarea> </p> 
         <!-- <p>房产证日期：<input type="text" name="house_date"> </p> -->
          <p><input type="submit" name="button" value="提交"/><input type="reset"name="cancel"value="重置"/></p>
        </form>
      </center>
    </div>
    <div id="foot">
      <hr/>
      <center>
        <p><a href="Index.jsp">租房系统</a></p>
      </center>
    </div>
  </body>
</html>
