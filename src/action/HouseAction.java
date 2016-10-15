package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Bean.HouseBean;
import Bean.StreetBean;
import Bean.TypeBean;
import Bean.UserBean;
import Biz.HouseBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HouseAction extends ActionSupport {
    private String title;
    private int type_id;
    private double floorate;
    private double price;
    private int street_id;
    private String contact;
    private String description;
    //private Date house_date;
    
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	
	public double getFloorate() {
		return floorate;
	}
	
	public void setFloorate(double floorate) {
		this.floorate = floorate;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStreet_id() {
		return street_id;
	}
	
	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*public Date getHouse_date() {
		return house_date;
	}
	
	public void setHouse_date(Date house_date) {
		this.house_date = house_date;
	}*/
	
    public String addHouse() throws IOException{
        int i=add();
        HttpServletResponse response=ServletActionContext.getResponse();
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	if(i==1){
    		out.print("<script>alert('添加房屋信息成功');location='http://localhost:8080/HouseSystem/Index.jsp';</script>");
    	}
    	out.print("<script>alert('添加房屋信息失败');location='http://localhost:8080/HouseSystem/Add_House.jsp';</script>");
		out.flush();
		out.close();
    	return null;
    }
    
    public int add(){
    	int i=0;
    	ActionContext ac=ActionContext.getContext();
    	Map session=(Map) ac.getSession();
    	String user=null;
    	//遍历Map
    	Iterator it=session.entrySet().iterator();
    	while(it.hasNext()){;   
    	    Map.Entry entry = (Entry) it.next();
    	    if(entry.getKey().equals("user_id")){
        		user=entry.getValue().toString();
    	    }    
        }
    	int user_id=Integer.parseInt(user);
    	Date date = new Date();
		HouseBean house=new HouseBean();
		TypeBean type=new TypeBean();
		StreetBean street=new StreetBean();
		UserBean usb=new UserBean();
		//house.setUser_id(user_id);
        type.setId(type_id);
        street.setId(street_id);
		usb.setId(user_id);
		house.setUser(usb);
		house.setType(type);
		house.setStreet(street);
		house.setTitle(title);
		//house.setType_id(type_id);
		house.setFloorate(floorate);
		house.setPrice(price);
		//house.setStreet_id(street_id);
		house.setContact(contact);
		house.setDescription(description);
		house.setDate(date);
		//house.setHouse_date(house_date);
		HouseBiz hb=new HouseBiz();
		i=hb.AddHouse(house);
		System.out.println(this.getType_id());
		return i;
    }
}
