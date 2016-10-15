<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  
  <body>
    <center>
    <sx:head/>
    
    ${message }
    <s:form cssClass="post" action="login2.action" id="log">
      <p>
                    姓名:<input name="username" type="text"/>
                    密&nbsp;码：<input name="password" type="password"/>
      <s:hidden name="action" value="ajax"></s:hidden>
      <sx:submit type="button" value="登陆" executeScripts="true"></sx:submit> 
      </p>
    </s:form>
   
    </center>
  </body>
</html>
