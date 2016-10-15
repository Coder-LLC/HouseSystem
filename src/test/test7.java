package test;


import java.util.Iterator;
import java.util.List;

import Bean.HouseBean;
import Biz.UserBiz;

public class test7 {

	public static void main(String[] args) {
		UserBiz ub=new UserBiz();
		HouseBean house=new HouseBean();  
		List list=ub.GetUserHouse(1,0,1);	
        Iterator <HouseBean> it=list.iterator();
        while(it.hasNext()){
        	house=it.next();
        	System.out.println(house.getDescription());
        }
	}

}
