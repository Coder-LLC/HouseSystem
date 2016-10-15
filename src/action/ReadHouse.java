package action;

import java.util.List;
import java.util.Map;

import Biz.HouseBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReadHouse extends ActionSupport {
    private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public String read () throws Exception {
		HouseBiz hb=new HouseBiz();
		List list=hb.GetHouseById(id);
		ActionContext ac=ActionContext.getContext();
		Map request=(Map) ac.get("request");
		request.put("list", list);
		return SUCCESS;
	}
}
