package com.javasj.dao;

import com.javasj.entity.Criticism;
/**
* @ClassName: CriticismDao 
* @Description: TODO(批复管理接口) 
* @author 王小圈 
* @date 2015年10月26日 下午11:18:56 
*
 */
public interface CriticismDao {
	/**
	* @Title: addCriticism 
	* @Description: TODO(添加一个批复) 
	* @param @param criticism  批复对象
	* @return int    返回类型 
	* @throws
	 */
	public int addCriticism(Criticism criticism);
	/**
	* @Title: findCriticismByMessageId 
	* @Description: TODO(根据消息编号加载批复) 
	* @param @param messageId 消息编号
	* @param @return   批复信息
	* @return Criticism    返回类型 
	* @throws
	 */
	public Criticism findCriticismByMessageId(int messageId);
}
