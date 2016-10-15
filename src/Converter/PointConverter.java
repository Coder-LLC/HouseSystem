package Converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import Bean.Point;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class PointConverter extends StrutsTypeConverter {
    public Object convertFromString(Map context,String[] values,Class toTyte){
    	String s=values[0];
    	String xy[]=s.split(",");
    	if(xy.length!=2){
    		throw new TypeConversionException();
    	}
    	Point point=new Point();
    	point.setX(Double.parseDouble(xy[0]));
    	point.setY(Double.parseDouble(xy[1]));
    	return point;
    }
    
    public String convertToString(Map context,Object object){
    	Point point=(Point) object;
    	Double x=point.getX();
    	Double y=point.getY();
    	String s="("+ x +","+ y +")";
    	return s;
    }
}
