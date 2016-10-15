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
   <title>修改房屋信息</title>
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
    }
    </script>
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
      <center>
      <form name="info" action="servlet/Do_AddHouse" method="post" onsubmit="return check()">
      <p> 标题：<input type="text" name="title" value="${list1.title}"> </p>
      <p> 
                            请选择房屋类型：
         <select name="type_id">
         <c:forEach var="list3" items="${requestScope.list3 }" varStatus="Status">
           <option value="${list3.id }">
             ${list3.name }
           </option>
         </c:forEach>
         </select> 
      </p>
      <p> 房屋面积:<input type="text" name="floorate" value="${list1.floorate }"> </p>
      <p> 房屋价格:<input type="text" name="price" value="${list.price }"> </p>
      <p>
                        区:
        <select name="district_id">
        <c:forEach var="list2" items="${requestScope.list2 }" varStatus="Status">
          <option value="${list2.id }">
            ${list2.name }
          </option>
        </c:forEach>  
        </select>
                        街道:
        <select name="street_id">
        <c:forEach var="list4" items="${requestScope.list4 }" varStatus="Status">
          <option value="${list4.id }">
            ${list4.name }
          </option>
        </c:forEach>
        </select>
      </p>
      <p> 联系方式:<input type="text" name="contact" value="${list1.contact }"> </p>
      <p> 房屋描述:<textarea name="description" rows="5" cols="60">${list1.description }</textarea> </p> 
      <p><input type="submit"name="button"value="提交" /><input type="reset"name="cancel"value="重置"/></p>
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
