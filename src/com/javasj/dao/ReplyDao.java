package com.javasj.dao;

import java.util.List;

import com.javasj.entity.Reply;
import com.javasj.util.Page;
/**
* @ClassName: ReplyDao 
* @Description: TODO(消息回复管理接口) 
* @author 王小圈 
* @date 2015年10月26日 下午11:08:48 
*
*/
public interface ReplyDao {
	/**
	* @Title: addReply 
	* @Description: TODO(添加一个消息回复) 
	* @param @param reply  消息回复对象 
	* @return void    返回类型 
	* @throws
	*/
	public void addReply(Reply reply);
	/**
	* @Title: updateReply 
	* @Description: TODO(更新回复消息内容) 
	* @param @param reply 回复对象
	* @return void    返回类型 
	* @throws
	 */
	public void updateReply(Reply reply);
	/**
	* @Title: deleteReply 
	* @Description: TODO(删除回复) 
	* @param @param replyId  回复编号
	* @return void    返回类型 
	* @throws
	 */
	public void deleteReply(int replyId);
	/**
	* @Title: findReplyByMessageId 
	* @Description: TODO(根据消息编号带分页来查询该消息回复列表) 
	* @param @param messageId 消息编号
	* @param @param page 分页对象
	* @param @return  返回回复列表
	* @return List<Reply>    返回类型 
	* @throws
	*/
	public List<Reply> findReplyByMessageId(int messageId,Page page);
	/**
	* @Title: findCountByMessaggeId 
	* @Description: TODO(根据消息编号来查询该消息回复总数) 
	* @param @param messageId 消息编号
	* @param @return 消息回复总条数
	* @return int    返回类型 
	* @throws
	*/
	public int findCountByMessaggeId(int messageId);
}
