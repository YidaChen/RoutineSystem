package com.javasj.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.javasj.dao.UserDao;
import com.javasj.dao.impl.UserDaoImpl;
import com.javasj.entity.User;
import com.javasj.util.Page;

public class testUser {
	@Test
	public void addUser(){
		UserDao userdao=new UserDaoImpl();
		User user=new User("test", "123", 1, new Date(), "11111111111", "黑龙江", 1);
		int result=userdao.addUser(user);
		System.out.println(result);
	}
	@Test
	public void updateUser(){
		UserDao userdao=new UserDaoImpl();
		User user=new User(2,"zhangsan", "123", 1, new Date(), "11111111111", "黑龙江", 1, 0);
		int result=userdao.updateUser(user);
		System.out.println(result);
	}
	@Test
	public void deletUser(){
		UserDao userdao=new UserDaoImpl();
		int result=userdao.deleteUser(3);
		System.out.println(result);
	}
	@Test
	public void loadUser(){
		UserDao userdao=new UserDaoImpl();
		User user=userdao.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void findAllUser(){
		UserDao userdao=new UserDaoImpl();
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		List<User> userlist=userdao.findAllUser(page);
		System.out.println(userlist);
	}
	@Test
	public void findAllUserCount(){
		UserDao userdao=new UserDaoImpl();
		System.out.println(userdao.findUserCount());
	}
	@Test
	public void findUserByUserInfo(){
		UserDao userdao=new UserDaoImpl();
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		User user=new User();
		user.setUserName("a");
		List<User> userlist=userdao.findUserByUserInfo(user, page);
		System.out.println(userlist);
	}
	@Test
	public void findUserByUserInfoCount(){
		UserDao userdao=new UserDaoImpl();
		User user=new User();
		user.setUserName("a");
		System.out.println(userdao.findUserCountByUserInfo(user));
	}
}
