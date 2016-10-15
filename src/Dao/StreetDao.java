package Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import Hibernate.HibernateSessionFactory;

public class StreetDao {
	public List GetAllStreet(){
		List list=null;
		try{
			Session session=HibernateSessionFactory.getSession();
			String hql="from StreetBean";
			Query query=session.createQuery(hql);
			list=query.list();
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
	
    public List GetStreetByDistrict(int district_id){
    	List list=null;
    	try{
    		Session session=HibernateSessionFactory.getSession();
    		String hql="select s from StreetBean as s where s.district_id=?";
    		Query query=session.createQuery(hql);
    		query.setInteger(0, district_id);
    		list=query.list();
    	}
    	catch(HibernateException e){
    		e.printStackTrace();
    	}
    	finally{
    		HibernateSessionFactory.closeSession();
    	}
    	return list;
    }
}
