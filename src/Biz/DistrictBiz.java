package Biz;

import java.util.List;

import Dao.DistrictDao;

public class DistrictBiz {
	DistrictDao dd=new DistrictDao();
	public List GetDistrict(){
		List list=dd.GetDistrict();
		return list;
	}
	
	public List GetDistrict(int id){
		List list=dd.GetDistrictById(id);
		return list;
	}
	
	public List GetDistrictAndStreetById(int district_id){
		List list=dd.GetDistrictAndStreetById(district_id);
		return list;
	}
	
}
