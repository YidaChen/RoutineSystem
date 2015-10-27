package com.javasj.util;
/**
* 
* @ClassName: StringUtil 
* @Description: TODO(判断字符串是否为空) 
* @author 王小圈 
* @date 2015年10月28日 上午12:28:46 
*
*/
public class StringUtil {
	/**
	* 
	* @Title: isNull 
	* @Description: TODO(根据用户传来的字符串判断是否为空) 
	* @param @param str 输入字符串
	* @param @return   返回布尔型
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isNull(String str){
		if(str==null||str.equals(""))
			return false;
		else return true;
	}
}
