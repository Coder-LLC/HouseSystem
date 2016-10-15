<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  #head{width:100%;border:0px;color:#FF0000;height:100px;}
  #main{height:300px;border:0px;width:100%;}
  #foot{height:50px;border:0px;width:100%;}
  </style>
  <title>用户登录</title>
  <script type="text/javascript">
    function check(){
	   if(document.Login.username.value==""){
		 alert("用户名不能为空");
		 return false;
	   }
	   if(document.Login.password.value==""){
		 alert("密码不能为空");
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
       ${message}
       <form name="Login" method="post" action="loginUser.action" onsubmit="return check()"> 
          <p> 用户名：<input type="text" name="username"></p>
          <p> 密&nbsp;码：  <input type="password" name="password"></p>
          <p> <input type="submit" value="登陆"> <input type="reset" value="清除"> </p>
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
