<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  #head{width:100%;border:0px;color:#FF0000;height:100px;}
  #main{height:300px;border:0px;width:100%;}
  #foot{height:50px;border:0px;width:100%;}
  </style>
  <title>用户注册</title>
  <script type="text/javascript">
 function check(){
	 if(document.Register.name.value==""){
		 alert("用户名不能为空");
		 return false;
	 }
	 if(document.Register.username.value==""){
		 alert("用户昵称不能为空");
		 return false;
	 }
	 if(document.Register.password.value==""){
		 alert("密码不能为空");
		 return false;
     }
	 if(document.Register.tellphone.value==""){
		 alert("联系电话不能为空");
		 return false;
     }
	 if(document.Register.sure.value==""){
		 alert("确认密码不能为空");
		 return false;
	 }
	 if(document.Register.sure.value!=document.Login.password.value){
		 alert("两次密码不一致，请检查后重试");
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
    ${info }
     <form name="Register" method="post" action="registerUser.action" onsubmit="return check()"> 
        <p> 用户姓名：<input type="text" name="name"> </p>
        <p> 用户昵称：<input type="text" name="username"> </p>
        <p> 密&nbsp;码：  <input type="password" name="password"> </p>
        <p> 联系电话：<input type="text" name="tellphone"> </p>
        <p> 确认密码：<input type="password" name="sure"> </p>
        <p> <input type="submit" value="注册"> <input type="reset" value="取消"> </p>
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
