package com.javasj.entity;

import java.util.Date;

/**
 * 
* @ClassName: Criticism 
* @Description: TODO(批复实体类) 
* @author 王小圈 
* @date 2015年10月26日 下午9:28:09 
*
 */
public class Criticism {
	/**
	 * 批复编号
	 */
	private int criticismId;
	/**
	 * 批复内容
	 */
	private String crititcismContent;
	/**
	 * 批复时间
	 */
	private Date criticismTime;
	/**
	 * 批复人
	 */
	private User user;
	/**
	 * 批复消息
	 */
	private Message message;
	public int getCriticismId() {
		return criticismId;
	}
	public void setCriticismId(int criticismId) {
		this.criticismId = criticismId;
	}
	public String getCrititcismContent() {
		return crititcismContent;
	}
	public void setCrititcismContent(String crititcismContent) {
		this.crititcismContent = crititcismContent;
	}
	public Date getCriticismTime() {
		return criticismTime;
	}
	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Criticism [criticismId=" + criticismId + ", crititcismContent=" + crititcismContent + ", criticismTime="
				+ criticismTime + ", user=" + user + ", message=" + message + "]";
	}
	
}
