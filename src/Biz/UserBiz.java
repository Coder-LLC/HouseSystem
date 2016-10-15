package Biz;

import java.util.Iterator;
import java.util.List;

import Bean.HouseBean;
import Bean.UserBean;
import Dao.UserDao;

public class UserBiz {
	UserDao ud=new UserDao();
	public boolean UserRegist(UserBean user){
		boolean b=false;
		b=ud.UserRigest(user);
		return b;
	}
	
	public boolean CheckRigester(UserBean user){
		boolean b=true;
		List list=ud.CheckRigester(user);
		Iterator it=list.iterator();
		if(it.hasNext()){
			b=false;
		}
		return b;
	}
	
    public List UserLogin(UserBean user){
    	List list=ud.UserLogin(user);
    	return list;
    }
    
    public List GetUserHouse(int user_id,int start,int size){
    	List list=ud.GetUserHouse(user_id,start,size);
    	return list;
    }
    
    public int getUserHouseCount(int user_id){
    	int count=0;
    	count=ud.getUserHouseCount(user_id);
    	return count;
    }
}
