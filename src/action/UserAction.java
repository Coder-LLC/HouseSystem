package action;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Bean.UserBean;
import Biz.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private String name;
	private String tellphone;
	private String nextpage;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTellphone() {
		return tellphone;
	}

	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}

	public String getNextpage() {
		return nextpage;
	}

	public void setNextpage(String nextpage) {
		this.nextpage = nextpage;
	}

	UserBiz ub=new UserBiz();
	
    public String login () throws Exception {
    	boolean b=false;
    	UserBean user=new UserBean();
    	user.setUsername(username);
    	user.setPassword(password);
    	List list=ub.UserLogin(user);
    	ActionContext ac=ActionContext.getContext();
    	HttpServletResponse response=ServletActionContext.getResponse();
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	Iterator <UserBean> it=list.iterator();
    	if(it.hasNext()){
    		user=it.next();
    	    if(username.equals(user.getUsername())&&password.equals(user.getPassword())){
    		    Map session=ac.getSession();
    		    session.put("user_id", user.getId());
    		    session.put("username", user.getName());
    		    session.put("login", user);
    		    if(user.getIsadmin()){
    			    nextpage="admin";  
    		    }
    		    else{
    		    	nextpage="user";
    		    }
    		    return SUCCESS;
    	    }
    	    else{
    	    	out.print("<script>alert('密码错误，请检查后重试');location='http://localhost:8080/HouseSystem/Login.jsp';</script>");
    	    }   
    	}
    	else{
            out.print("<script>alert('用户名不存在，请检查后重试');location='http://localhost:8080/HouseSystem/Login.jsp';</script>");
    	}   
    	out.flush();
	    out.close();
    	return null;	
    	
    }
    
    public String register () throws Exception{
    	boolean b=false;
    	boolean c=false;
    	HttpServletResponse response=ServletActionContext.getResponse();
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	UserBean user=new UserBean();
    	user.setName(name);
    	user.setPassword(password);
    	user.setTellphone(tellphone);
    	user.setUsername(username);
    	b=ub.CheckRigester(user);	
    	ActionContext ac=ActionContext.getContext();
    	if(b==true){
        	if(c){
        		out.print("<script>alert('注册成功');</script>");
        		return INPUT;
        	}
        	else{
             	Map request=(Map)ac.get("request");//解耦合访问request
             	request.put("info", "注册失败,请稍后重试");
             	return ERROR;
            }
    	}
    	else{
         	Map request=(Map)ac.get("request");
         	request.put("info", "用户昵称已存在,请更换后重试");
         	return ERROR;
        }       
    }
}
