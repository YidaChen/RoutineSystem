package com.javasj.service.impl;

import java.util.List;

import com.javasj.dao.UserDao;
import com.javasj.dao.impl.UserDaoImpl;
import com.javasj.entity.User;
import com.javasj.service.UserService;
import com.javasj.util.MD5Util;
import com.javasj.util.Page;
import com.javasj.util.StringUtil;

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
			sql+=StringUtil.isNull(user.getUserName())?"and userName like '%"+user.getUserName()+"%'":"";
			sql+=StringUtil.isNull(user.getUserPlace())?"and userPlace like '%"+user.getUserPlace()+"%'":"";
			sql+=user.getUserSex()!=0?"and userSex ="+user.getUserSex():"";
			sql+=user.getStatus()!=0?"and status ="+user.getStatus():"";
			sql+=user.getIsAdmin()!=0?"and isAdmin ="+user.getIsAdmin():"";
			sql+=user.getUserBirthday()!=null?"and userBirthDay <'"+user.getUserBirthday()+"'":"";
			sql+=user.getJoinTime()!=null?"and joinTime <'"+user.getJoinTime()+"'":"";
		}
		return sql;
	}
	@Override
	public User findUserByUserName(String username) {
		return userdao.findUserByUserName(username);
	}
	@Override
	public User userLogin(String username, String password) {
		User user=this.findUserByUserName(username);
		if(user!=null){
			if(user.getPassword().equals(MD5Util.md5(password))) return user;			
			else return null;
		}else{
			return null;
		}
	}

	

}
