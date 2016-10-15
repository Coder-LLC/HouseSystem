package action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Bean.UserBean;
import Biz.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login2 extends ActionSupport {
	private String username;
	private String password;
	private String action;
	private String message;
	
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute(){
		UserBean user=new UserBean();
		UserBiz ub=new UserBiz();
    	user.setUsername(username);
    	user.setPassword(password);
    	List list=ub.UserLogin(user);
    	ActionContext ac=ActionContext.getContext();
    	Iterator <UserBean> it=list.iterator();
    	if(it.hasNext()){
    		user=it.next();
    	    if(username.equals(user.getUsername())&&password.equals(user.getPassword())){
    		    Map session=ac.getSession();
    		    session.put("user_id", user.getId());
    		    session.put("username", user.getName());
    		    session.put("login", user);
    		    if(getAction().length()!=0&&getAction().equals("ajax")){
    		    	this.setMessage("欢迎："+user.getName()+"登陆");
    		    	return "ajaxLogin";
    		    }
    		    return SUCCESS;
    	    }
    	    else{
    	    	 if(getAction().length()!=0&&getAction().equals("ajax")){
    		        this.setMessage("用户名或密码错误，请检查后重试");
    		        return "ajaxLogin";
    	         }  
    	    	 return INPUT;
    	    }	 
    	}
    	else{
    		if(getAction().length()!=0&&getAction().equals("ajax")){
    		    this.setMessage("用户名不存在，请检查后重试");
		        return "ajaxLogin";
    	    }   
    		return INPUT;
    	}	
    }
}
