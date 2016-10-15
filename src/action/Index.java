package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Biz.HouseBiz;

public class Index extends ActionSupport{
	private String pageNumber=null;
	
	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String execute(){
	    //分页
	    String number=pageNumber;
	    if(number==null||number.equals("")){
	      number="1";
	    } 
	    int pagenumber=Integer.parseInt(number); 
	    HouseBiz hb=new HouseBiz();
	    int count=hb.GetCount();
	    int size=3;//每页显示条数
	    int totalpage=count/size;
	    if(count%size!=0){
		    totalpage++;
	    }
	    int start=0; 
	    start=(pagenumber-1)*size;
	    List list=hb.GetHouseByPageId(start, size);
	    ActionContext ac=ActionContext.getContext();
	    Map request=(Map)ac.get("request");//解耦合访问request 	;
	    request.put("list",list );
	    request.put("totalpage", totalpage);        
     	return SUCCESS;
	}
}
