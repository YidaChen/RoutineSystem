package com.javasj.test;

import java.util.Date;

import org.junit.Test;

import com.javasj.dao.UserDao;
import com.javasj.dao.impl.UserDaoImpl;
import com.javasj.entity.User;

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
}
