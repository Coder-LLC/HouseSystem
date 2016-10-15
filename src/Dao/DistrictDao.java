package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import Hibernate.HibernateSessionFactory;

public class DistrictDao {
	public List GetDistrict(){
		List list=new ArrayList();
    	try{
    		Session session=HibernateSessionFactory.getSession();
    		String hql="from DistrictBean";
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
	
	public List GetDistrictById(int id){
		List list=new ArrayList();
    	try{
    		Session session=HibernateSessionFactory.getSession();
    		String hql="from DistrictBean as d where d.id=?";
    		Query query=session.createQuery(hql);
    		query.setInteger(0, id);
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
	
	
    public List GetDistrictAndStreetById(int district_id){
    	List list=new ArrayList();
    	try{
    		Session session=HibernateSessionFactory.getSession();
    		String hql="from DistrictBean as d inner join fetch d.streets s where d.id=?";
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
