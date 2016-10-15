package Biz;

import java.util.List;

import Dao.TypeDao;

public class TypeBiz {
    TypeDao td=new TypeDao();
    public List GetType(){
    	List list=td.GetType();
    	return list;
    }
}
