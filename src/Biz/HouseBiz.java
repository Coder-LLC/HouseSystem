package Biz;

import java.util.List;

import Bean.HouseBean;
import Bean.QueryHouseBean;
import Dao.HouseDao;

public class HouseBiz {
    HouseDao hd=new HouseDao();
    public int GetCount(){
    	int i=0;
    	i=hd.GetCount();
    	return i;
    }
    
    public List GetHouseByPageId(int start,int size){
    	List list=hd.GetHouseByPageId(start, size);
    	return list;
    }
    
    public List GetHouseById(int id){
    	List list=hd.GetHouseById(id);
    	return list;
    }
    
    public int AddHouse(HouseBean house){
    	System.out.println(house.getType_id());
    	int i=hd.AddHouse(house);
    	return i;
    }
    
    public int Modify(HouseBean house){
    	int i=hd.Modify(house);
    	return i;
    }
    
    public List getHouseByCondition(QueryHouseBean q){
    	List list=hd.getHouseByCondition(q);
    	return list;
    }
}
