package Biz;

import java.util.List;

import Dao.StreetDao;

public class StreetBiz {
	StreetDao sd=new StreetDao();
	public List GetAllStreet(){
		List list=sd.GetAllStreet();
		return list;
	}
	
    public List GetStreetByDistrict(int district_id){
	   List list=sd.GetStreetByDistrict(district_id);
	   return list;
   }
}
