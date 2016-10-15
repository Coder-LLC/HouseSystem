package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import Hibernate.HibernateSessionFactory;

public class TypeDao {
    public List GetType(){
    	List list=new ArrayList();
    	try{
    		Session session=HibernateSessionFactory.getSession();
    		String hql="from TypeBean";
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
}
