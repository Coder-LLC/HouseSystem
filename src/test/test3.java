package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Bean.DistrictBean;
import Bean.StreetBean;

class HibernateTest {
	DistrictBean district=new DistrictBean();
	StreetBean street1=new StreetBean();
	StreetBean street2=new StreetBean();
	StreetBean street3=new StreetBean();
	int i=0;
	public int ManyToOne(){
		district.setName("丰台区");
		street1.setName("长安街");
		street1.setDistrict(district);
		street2.setName("南苑街");
		street2.setDistrict(district);
		street3.setName("人民路");
		street3.setDistrict(district);
		Configuration conf=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tt=null;
		try{
	        conf = new Configuration();
	        conf.configure();
	        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry(); 
	        sessionFactory = new Configuration().configure().buildSessionFactory(sr);  //创建sessionFactory
	        session=sessionFactory.openSession();//打开session
	        tt=session.beginTransaction();//开始一个事务
	        session.save(district);//持久化操作
	        session.save(street1);
	        session.save(street2);
	        session.save(street3);
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
}
public class test3 {
	public static void main(String[] args) {
		HibernateTest ht=new HibernateTest();
		int i=ht.ManyToOne();
		System.out.print(i);
	}
}
