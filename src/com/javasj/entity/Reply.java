package com.javasj.entity;

import java.util.Date;

/**
 * 
* @ClassName: Reply 
* @Description: TODO(回复消息实体) 
* @author 王小圈 
* @date 2015年10月26日 下午9:02:48 
*
 */
public class Reply {
	/**
	 * 回复编号
	 */
	private int replyId;
	/**
	 * 回复内容
	 */
	private String replyContext;
	/**
	 * 回复人
	 */
	private User user;
	/**
	 * 回复时间
	 */
	private Date replyDate;
	/**
	 * 回复父类消息
	 */
	private Message message;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplyContext() {
		return replyContext;
	}
	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContext=" + replyContext + ", user=" + user + ", replyDate="
				+ replyDate + ", message=" + message + "]";
	}
	
}
