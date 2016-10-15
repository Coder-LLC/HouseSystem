package test;

import Bean.UserBean;
import Biz.UserBiz;

public class test4 {

	public static void main(String[] args) {
		UserBiz ub=new UserBiz();
		UserBean user=new UserBean();
		user.setName("name");
		user.setPassword("password");
		boolean b=ub.UserLogin(user);
		if(b){
			System.out.print("登陆成功");
		}
		else{
			System.out.print("登陆失败");
		}
	}

}
