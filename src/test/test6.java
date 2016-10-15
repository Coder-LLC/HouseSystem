package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Bean.DistrictBean;
import Bean.StreetBean;
import Biz.DistrictBiz;


public class test6 {

	public static void main(String[] args) {
		DistrictBiz db=new DistrictBiz();
        List list=db.GetDistrictAndStreetById(1);
        Iterator <DistrictBean> it=list.iterator();
        DistrictBean district=new DistrictBean();
        StreetBean street=new StreetBean();
        if(it.hasNext()){
        	district=it.next();
        	Set set=district.getStreets();
        	System.out.println(district.getName());
        	Iterator <StreetBean> i=set.iterator();
        	while(i.hasNext()){
        		street=i.next();
        		System.out.println(street.getName());
        	}
        	
        }

	}

}
