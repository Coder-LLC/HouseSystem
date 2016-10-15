package test;

import java.util.Iterator;
import java.util.List;

import Bean.HouseBean;
import Bean.QueryHouseBean;
import Biz.HouseBiz;

public class test8 {

	public static void main(String[] args) {
		HouseBiz ub=new HouseBiz();
		QueryHouseBean q=new QueryHouseBean();
		HouseBean house=new HouseBean();
		q.setHigh_price(90000000.0);;
		q.setLow_price(1.0);
		q.setHigh_floorate(90000000.0);
        q.setLow_floorate(1.0);
        List list=ub.getHouseByCondition(q);
        Iterator <HouseBean> it=list.iterator();
        while(it.hasNext()){
        	house=it.next();
        	System.out.println(house.getDescription());
        }
	}

}
