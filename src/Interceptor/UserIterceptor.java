package Interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Bean.UserBean;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserIterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation ai) throws Exception {
		Map session=ai.getInvocationContext().getSession();
		UserBean user=(UserBean)session.get("login");
		if(user==null){	
			HttpServletResponse response=ServletActionContext.getResponse();
	    	response.setContentType("text/html;charset=UTF-8");
	    	PrintWriter out=response.getWriter();
	    	out.print("<script>alert('您未登陆，请登录后重试');location='http://localhost:8080/HouseSystem/Login.jsp';</script>");
	    	out.flush();
	    	out.close();
			return Action.INPUT;//终止操作，返回登陆页
		}
		else{
			return ai.invoke();//继续下一步操作
		}
	}
}
