package com.javasj.entity;

import java.util.Date;

/**
 * 
* @ClassName: User 
* @Description: TODO(用户实体类) 
* @author 王小圈 
* @date 2015年10月26日 下午6:02:26 
*
 */
public class User {
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户性别
	 * 1、代表男2、代表女
	 */
	private int userSex;
	/**
	 * 用户出生日期
	 */
	private Date userBirthday;
	/**
	 * 用户电话号码
	 */
	private String userPhoneNumber;
	/**
	 * 用户居住地
	 */
	private String userPlace;
	/**
	 * 是否是管理员
	 */
	private int isAdmin;
	/**
	 * 加入公司时间
	 */
	private Date joinTime;
	/**
	 * 当前用户状态
	 */
	private int status;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserSex() {
		return userSex;
	}
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserPlace() {
		return userPlace;
	}
	public void setUserPlace(String userPlace) {
		this.userPlace = userPlace;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userSex=" + userSex
				+ ", userBirthday=" + userBirthday + ", userPhoneNumber=" + userPhoneNumber + ", userPlace=" + userPlace
				+ ", isAdmin=" + isAdmin + ", joinTime=" + joinTime + ", status=" + status + "]";
	}
	public User() {
		super();
	}
	public User(String userName, String password, int userSex, Date userBirthday, String userPhoneNumber,String userPlace, int isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userPhoneNumber = userPhoneNumber;
		this.userPlace = userPlace;
		this.isAdmin = isAdmin;
	}
	public User(int userId, String userName, String password, int userSex, Date userBirthday, String userPhoneNumber,String userPlace, int isAdmin, int status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userPhoneNumber = userPhoneNumber;
		this.userPlace = userPlace;
		this.isAdmin = isAdmin;
		this.status = status;
	}
	
}
