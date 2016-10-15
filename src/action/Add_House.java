package action;

import java.util.List;
import java.util.Map;

import Biz.DistrictBiz;
import Biz.StreetBiz;
import Biz.TypeBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Add_House extends ActionSupport{
    public String execute(){
		DistrictBiz db=new DistrictBiz();
		TypeBiz tb=new TypeBiz();
		StreetBiz sb=new StreetBiz();
		String flag="flag";
		List list1=tb.GetType();
		List list2=db.GetDistrict();
		List list3=sb.GetAllStreet();
		ActionContext ac=ActionContext.getContext();
		Map request=(Map) ac.get("request");
		request.put("flag", flag);
		request.put("list1", list1);
		request.put("list2", list2);
		request.put("list3", list3);
    	return SUCCESS;
    }
}
