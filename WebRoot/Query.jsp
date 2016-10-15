<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
      #head{width:100%;border:0px;color:#FF0000;height:100px;}
      #main{height:300px;border:0px;width:100%;}
      #foot{height:50px;border:0px;width:100%;}
    </style>
    
    <title>查询房屋</title>
    
    <script type="text/javascript">
      function check(){
	    if(document.query.low_price.value==""){
		  alert("最低价格不能为空");
		  return false;
	    }
	    if(document.query.high_price.value==""){
		  alert("最高价格不能为空");
		  return false;
        }
	    if(document.query.low_floorate.value==""){
		  alert("最小面积不能为空");
		  return false;
		}
		if(document.query.high_floorate.value==""){
		  alert("最大面积不能为空");
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
      <form name="query" action="QueryHouse.action" method="post" onsubmit="return check()">
        <p>请输入最低价格：<input type="text" name="low_price"></p>
        <p>请输入最高价格：<input type="text" name="high_price"></p>
        <p>请输入最小面积：<input type="text" name="low_floorate"></p>
        <p>请输入最大面积：<input type="text" name="high_floorate"></p>
        <p> <input type="submit" value="提交"> <input type="reset" value="清除"> </p>
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
