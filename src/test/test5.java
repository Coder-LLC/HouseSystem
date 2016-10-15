package test;

import java.util.Iterator;
import java.util.List;

import Bean.HouseBean;
import Biz.HouseBiz;

public class test5 {

	public static void main(String[] args) {
		HouseBiz hb=new HouseBiz();
        List list=hb.GetHouseByPageId(0, 3);
        Iterator <HouseBean> it=list.iterator();
        while(it.hasNext()){
        	HouseBean house=it.next();
        	System.out.println(house.getId());
        	System.out.println(house.getDescription());
        }
	}

}
