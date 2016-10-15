package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Bean.HouseBean;
import Bean.QueryHouseBean;
import Hibernate.HibernateSessionFactory;

public class HouseDao {
	public int GetCount(){
		long l=0;
		int count=0;
		try{
		    Session session=HibernateSessionFactory.getSession();
		    String hql="select count(house) from HouseBean as house";
		    l=(long)session.createQuery(hql).uniqueResult();//总条数    
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
	
    public List GetHouseByPageId(int start,int size){//分页
    	List list=new ArrayList();
    	try{  		
    		Session session=HibernateSessionFactory.getSession();
    		String hql="from HouseBean order by id desc";//倒序输出
    		Query query=session.createQuery(hql);
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
    	return list;
    }
    
    public List GetHouseById(int id){
    	List list=new ArrayList();
    	try{
    		Session session=HibernateSessionFactory.getSession();
    		String hql="from HouseBean as h where h.id=?";
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
    
    public int AddHouse(HouseBean house){
    	int i=0;
    	Transaction tx=null;
    	try{
    		Session session=HibernateSessionFactory.getSession();
    	    tx=session.beginTransaction();//开始一个事务
    		session.save(house);//持久化操作
    		tx.commit();//提交事务
    		i=1;
    	}
    	catch(HibernateException e){
    		tx.rollback();//回滚事务
    		e.printStackTrace();
    	}
    	finally{
    		HibernateSessionFactory.closeSession();
    	}
    	return i;
    }
    
    public int Modify(HouseBean house){
    	int i=0;
    	Transaction tx=null;
    	try{
    		Session session=HibernateSessionFactory.getSession();
    	    tx=session.beginTransaction();//开始一个事务
    		session.update(house);//持久化操作
    		tx.commit();//提交事务
    		i=1;
    	}
    	catch(HibernateException e){
    		tx.rollback();//回滚事务
    		e.printStackTrace();
    	}
    	finally{
    		HibernateSessionFactory.closeSession();
    	}
    	return i;
    }
    
    public List getHouseByCondition(QueryHouseBean q){
    	List list=new ArrayList();
    	try{
    		Session session=HibernateSessionFactory.getSession();
    		String hql="select h from HouseBean as h where ( h.price between ? and ? ) and ( h.floorate between ? and ? )";
    		Query query=session.createQuery(hql);
    		query.setLong(0, Math.round(q.getLow_price()));
    		query.setLong(1, Math.round(q.getHigh_price()));
    		query.setLong(2, Math.round(q.getLow_floorate()));
    		query.setLong(3, Math.round(q.getHigh_floorate()));
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
