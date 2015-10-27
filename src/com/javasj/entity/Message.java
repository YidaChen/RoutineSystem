package com.javasj.entity;

import java.util.Date;

/**
 * 
* @ClassName: Message 
* @Description: TODO(消息实体类) 
* @author 王小圈 
* @date 2015年10月26日 下午6:13:20 
*
 */
public class Message {
	/**
	 * 消息编号
	 */
	private int messageId;
	/**
	 * 消息标题
	 */
	private String messageTitle;
	/**
	 * 消息内容
	 */
	private String messageContent;
	/**
	 * 发布用户
	 */
	private User user;
	/**
	 * 发布时间
	 */
	private Date publicTime;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageTitle=" + messageTitle + ", messageContent="
				+ messageContent + ", user=" + user + ", publicTime=" + publicTime + "]";
	}
	
}
