package com.javasj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
* 
* @ClassName: DateUtil 
* @Description: TODO(时间类型和字符串类型的转换) 
* @author 王小圈 
* @date 2015年10月28日 上午12:28:25 
*
 */
public class DateUtil {
	/**
	* 
	* @Title: fmtStrToDate 
	* @Description: TODO(字符串转换成时间) 
	* @param @param dtFormat 输入时间字符串
	* @param @return   返回时间类型
	* @return Date    返回类型 
	* @throws
	 */
	public static Date fmtStrToDate(String dtFormat) { 
		dtFormat=dtFormat.substring(0, dtFormat.indexOf("PM")).trim();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");  
    	try {
			return dateFormat.parse(dtFormat);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}  
    }  
	/**
	* @Title: fmtDateToYMDHM 
	* @Description: TODO(时间转换成字符串) 
	* @param @param date 日期
	* @param @return   字符串型日期 
	* @return String    返回类型 
	* @throws
	 */
	public static String fmtDateToYMDHM(Date date) {  
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	return dateFormat.format(date);  
    }  
  
}
