package Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter{
	private final DateFormat[] dft = {
	    new SimpleDateFormat("yyyy年mm月dd日"),
	    new SimpleDateFormat("yyyy-mm-dd"),
	    new SimpleDateFormat("yyyy/mm/dd"),
	    new SimpleDateFormat("yyyy.mm.dd"),
	    new SimpleDateFormat("mm/dd/yy")
	};
	public Object convertFromString(Map context,String[] values,Class toTyte){
		String datestr=values[0];
		for(int i=0;i<dft.length;i++){
			try{
				return dft[i].parse(datestr);
			}
			catch(Exception e){
				continue;
			}
		}
		throw new TypeConversionException();
	}
	
	public String convertToString(Map context,Object object){
		Date date=(Date) object;
		return new SimpleDateFormat("yyyy年mm月dd日").format(date);
	}
}
