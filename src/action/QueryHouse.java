package action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Bean.QueryHouseBean;
import Biz.HouseBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryHouse extends ActionSupport {
	private String low_price;
	private String high_price;
	private String low_floorate;
	private String high_floorate;
	
    public String getLow_price() {
		return low_price;
	}

	public void setLow_price(String low_price) {
		this.low_price = low_price;
	}

	public String getHigh_price() {
		return high_price;
	}

	public void setHigh_price(String high_price) {
		this.high_price = high_price;
	}

	public String getLow_floorate() {
		return low_floorate;
	}

	public void setLow_floorate(String low_floorate) {
		this.low_floorate = low_floorate;
	}

	public String getHigh_floorate() {
		return high_floorate;
	}

	public void setHigh_floorate(String high_floorate) {
		this.high_floorate = high_floorate;
	}

	public String execute(){	
		ActionContext ac=ActionContext.getContext();
		Map request=(Map)ac.get("request");
		List list=getInfo();
		Iterator it=list.iterator();
		if(it.hasNext()){
			request.put("list", list);
			System.out.println("success");
		}	
		else{
			request.put("list2", "无查询结果");
		}
    	return SUCCESS;
    }
	
	public List getInfo(){
		double low_p=(double) Integer.parseInt(this.getLow_price());
		double high_p=(double) Integer.parseInt(this.getHigh_price());
		double low_f=(double) Integer.parseInt(this.getLow_floorate());
		double high_f=(double) Integer.parseInt(this.getHigh_floorate());
		QueryHouseBean q=new QueryHouseBean();
		q.setLow_price(low_p);
		q.setHigh_price(high_p);
		q.setLow_floorate(low_f);
		q.setHigh_floorate(high_f);
		HouseBiz hb=new HouseBiz();
		List list=hb.getHouseByCondition(q);
		return list;
	}
}
