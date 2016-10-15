package Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import Hibernate.HibernateSessionFactory;

public class BaseDao {
	public List executeQuery(String hql,List list1){
		List list2=new ArrayList();
		int i=-1;
        try{
    	   Session session=HibernateSessionFactory.getSession();
    	   Query query=session.createQuery(hql);
    	   Iterator it=list1.iterator();
    	   while(it.hasNext()){
    		   i=i+1;
    		   query.setEntity(i, it.next());
    	   }
    	   list2=query.list();
        }
        catch(HibernateException e){
    	  e.printStackTrace();
        }
        finally{
    	    HibernateSessionFactory.closeSession();
        }
        return list2;
	}
}
