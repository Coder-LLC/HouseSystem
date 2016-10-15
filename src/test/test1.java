package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Bean.HouseBean;

class Hibernate{
	Configuration conf=null;
	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction tt=null; 
	HouseBean hbn=new HouseBean();
	int i;
	public int save(){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date = null;
		try {
			date = sdf.parse("2011-08-20 9:10:12");
		} 
		catch(ParseException e1) {	
			e1.printStackTrace();
		}
		hbn.setFloorate(90.0);
		hbn.setType_id(2);
		hbn.setUser_id(10);
		hbn.setStreet_id(11);
		hbn.setTitle("title");
		hbn.setDescription("description");  
		hbn.setDate(date);
		hbn.setPrice(1155458.00);
		hbn.setContact("aaaa");  	   
	    try{
	    	conf = new Configuration();
	    	conf.configure();
	    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry(); 
	    	sessionFactory = conf.buildSessionFactory(sr);  //创建sessionFactory
	    	session=sessionFactory.openSession();//打开session
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
	    	session.close();
	    	sessionFactory.close();
	    }  
	    return i;
	}
	
	public int SelectHouse(){
		try{
	    	conf = new Configuration();
	    	conf.configure();
	    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry(); 
	    	sessionFactory = conf.buildSessionFactory(sr);  //创建sessionFactory
	    	session=sessionFactory.openSession();//打开session
	    	tt=session.beginTransaction();//开始一个事务
	    	session.load(hbn, 2);
	    	tt.commit();//提交事务 
	    	i=1;
	    }
	    catch(HibernateException e){
	    	e.printStackTrace();	   
	    }
	    finally{
	    	session.close();
	    	sessionFactory.close();
	    }  
		return i;
	}	
}
public class test1 {    
	public static void main(String[] args){
		Hibernate hb=new Hibernate();
		int i=hb.save();
		System.out.println(i);
	}
}
