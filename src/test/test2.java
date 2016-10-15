package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Bean.StreetBean;

import Hibernate.*;

class StreetTest{
	int i;
	public int save(){
		StreetBean hbn=new StreetBean();
	    hbn.setName("民主路");
	    Configuration conf=null;
	    SessionFactory sessionFactory=null;
	    Session session=null;
	    Transaction tt=null; 
	    try{
	    	//conf = new Configuration();
	    	//conf.configure();
	    	//ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry(); 
	    	//sessionFactory = conf.buildSessionFactory(sr);  //创建sessionFactory
	    	//session=sessionFactory.openSession();//打开session
	    	session= HibernateSessionFactory.getSession();
	    	tt=session.beginTransaction();//开始一个事务
	    	session.save(hbn);//持久化操作
	    	tt.commit();//提交事务 
	    	i=1;
	    }
	    catch(HibernateException e){
	    	tt.rollback();//回滚事务
	    	e.printStackTrace();	   
	    }
	    finally{
	    	//session.close();
	    	//sessionFactory.close();
	    	HibernateSessionFactory.closeSession();
	    }  
	    return i;
	}
}
public class test2 {    
	public static void main(String[] args){
		StreetTest hb=new StreetTest();
		int i=hb.save();
		System.out.print(i);
	}
}
