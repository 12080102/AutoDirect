package crunch.kevin.springmvc.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static final String DoubleFormat(double data) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		return df.format(data);
	}
	
	public static final String Dateformat(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public static Date stringToDate(String str) {  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {  
            // Fri Feb 24 00:00:00 CST 2012  
            date = format.parse(str);   
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        // 2012-02-24  
        date = java.sql.Date.valueOf(str);  
                                              
        return date;  
    }  
}
