package Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Bean.HouseBean;
import Bean.UserBean;
import Hibernate.HibernateSessionFactory;

public class UserDao {
    Configuration conf=null;
	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction tt=null;
	List list=new ArrayList();
    public boolean UserRigest(UserBean user){  
    	boolean b=false;
    	try{
	        conf = new Configuration();
	        conf.configure();
	        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry(); 
	        sessionFactory = conf.buildSessionFactory(sr);  //创建sessionFactory
	        session=sessionFactory.openSession();//打开session
	        tt=session.beginTransaction();//开始一个事务
	        session.save(user);//持久化操作
	        tt.commit();//提交事务 
	        b=true;
	    }
	    catch(HibernateException e){
	        tt.rollback();//回滚事务
	        e.printStackTrace();	   
	    }
	    finally{
	        session.close();
	        sessionFactory.close();
	    } 
    	return b;
	}
    
    public List CheckRigester(UserBean user){
    	try{
    		session=HibernateSessionFactory.getSession();
    		String hql="select u.username from UserBean as u where u.username=?";
    		Query query=session.createQuery(hql);
    		query.setString(0, user.getUsername());
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
    
    public List UserLogin(UserBean user){
    	try{
    		session= HibernateSessionFactory.getSession();
    		String hql="from UserBean as u where u.username=?";
    		Query query=session.createQuery(hql);
    		query.setString(0, user.getUsername());	
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
    
    public List GetUserHouse(int user_id,int start,int size){
    	try{
    		session=HibernateSessionFactory.getSession();
    		String hql="from HouseBean where user_id=? order by id desc";
    		Query query=session.createQuery(hql);
    		query.setLong(0, user_id);
    		query.setFirstResult(start);
    		query.setMaxResults(size);
    		list=query.list();
    	}
    	catch(HibernateException e){
    		e.printStackTrace();
    	}
    	finally{
    		HibernateSessionFactory.closeSession();
    	}
    	/*BaseDao bd=new BaseDao();
    	List list2=new ArrayList();
    	list2.add(house.getUser_id());
    	String hql="select h from HouseBean as h where h.id=?";
    	list=bd.executeQuery(hql, list2);*/
    	return list;
    }
    
    public int getUserHouseCount(int user_id){
		long l=0;
		int count=0;
		try{
		    Session session=HibernateSessionFactory.getSession();
		    String hql="select count(house) from HouseBean as house where house.user_id=?";
		    Query query=session.createQuery(hql);
		    query.setLong(0, user_id);
		    l=(long)query.uniqueResult();//总条数    
		    count=new Long(l).intValue();//long转换为int型
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
		return count;
    }
}