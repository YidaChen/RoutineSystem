package com.javasj.service.impl;

import java.util.List;

import com.javasj.dao.UserDao;
import com.javasj.dao.impl.UserDaoImpl;
import com.javasj.entity.User;
import com.javasj.service.UserService;
import com.javasj.util.Page;

public class UserServiceImpl implements UserService {
	UserDao userdao=new UserDaoImpl();
	@Override
	public int addUser(User user) {
		return userdao.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userdao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return userdao.deleteUser(id);
	}

	@Override
	public User findUserById(int id) {
		return userdao.findUserById(id);
	}

	@Override
	public List<User> findAllUser(Page page) {
		return userdao.findAllUser(page);
	}

	@Override
	public List<User> findUserByUserInfo(User user, Page page) {
		return userdao.findUserByUserInfo(page, addSql(user));
	}

	@Override
	public int findUserCount() {
		return userdao.findUserCount();
	}

	@Override
	public int findUserCountByUserInfo(User user) {
		return userdao.findUserCountByUserInfo(addSql(user));
	}
	public String addSql(User user){
		String sql="";
		if(user!=null){
			sql+=user.getUserName()!=null&&!user.getUserName().equals("")?"and userName like '%"+user.getUserName()+"%'":"";
			sql+=user.getUserPlace()!=null&&!user.getUserPlace().equals("")?"and userPlace like '%"+user.getUserPlace()+"%'":"";
			sql+=user.getUserSex()!=0?"and userSex ="+user.getUserSex():"";
			sql+=user.getStatus()!=0?"and status ="+user.getStatus():"";
			sql+=user.getIsAdmin()!=0?"and isAdmin ="+user.getIsAdmin():"";
			sql+=user.getUserBirthday()!=null?"and userBirthDay <'"+user.getUserBirthday()+"'":"";
			sql+=user.getJoinTime()!=null?"and joinTime <'"+user.getJoinTime()+"'":"";
		}
		return sql;
	}
}
