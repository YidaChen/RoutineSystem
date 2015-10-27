package com.javasj.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import com.javasj.entity.User;
import com.javasj.service.UserService;
import com.javasj.service.impl.UserServiceImpl;
import com.javasj.util.Page;

public class testUser {
	@Test
	public void addUser(){
		UserService userService=new UserServiceImpl();
		User user=new User("test", "123", 1, new Date(), "11111111111", "黑龙江", 1);
		int result=userService.addUser(user);
		System.out.println(result);
	}
	@Test
	public void updateUser(){
		UserService userService=new UserServiceImpl();
		User user=new User(4,"zhangsan", "123", 1, new Date(), "11111111111", "黑龙江", 1, 0);
		int result=userService.updateUser(user);
		System.out.println(result);
	}
	@Test
	public void deletUser(){
		UserService userService=new UserServiceImpl();
		int result=userService.deleteUser(3);
		System.out.println(result);
	}
	@Test
	public void loadUser(){
		UserService userService=new UserServiceImpl();
		User user=userService.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void findAllUser(){
		UserService userService=new UserServiceImpl();
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		List<User> userlist=userService.findAllUser(page);
		System.out.println(userlist);
	}
	@Test
	public void findAllUserCount(){
		UserService userService=new UserServiceImpl();
		System.out.println(userService.findUserCount());
	}
	@Test
	public void findUserByUserInfo(){
		UserService userService=new UserServiceImpl();
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		User user=new User();
		user.setUserName("a");
		List<User> userlist=userService.findUserByUserInfo(user, page);
		System.out.println(userlist);
	}
	@Test
	public void findUserByUserInfoCount(){
		UserService userService=new UserServiceImpl();
		User user=new User();
		user.setUserName("a");
		System.out.println(userService.findUserCountByUserInfo(user));
	}
}
