package com.javasj.dao.impl;

import java.util.Date;
import java.util.List;

import com.javasj.dao.BaseDao;
import com.javasj.dao.UserDao;
import com.javasj.entity.User;
import com.javasj.util.Page;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int addUser(User user) {
		String sql="insert into t_user (userName,password,userSex,userBirthDay,userPhoneNumber,userPlace,isAdmin,joinTime,status) values(?,?,?,?,?,?,?,?,?)";
		Object[]param={user.getUserName(),user.getPassword(),user.getUserSex(),user.getUserBirthday(),user.getUserPhoneNumber(),user.getUserPlace(),user.getIsAdmin(),new Date(),1};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int updateUser(User user) {
		String sql="update t_user set userName=?,password=?,userSex=?,userBirthDay=?,userPhoneNumber=?,userPlace=?,isAdmin=?,status=? where userId=?";
		Object[]param={user.getUserName(),user.getPassword(),user.getUserSex(),user.getUserBirthday(),user.getUserPhoneNumber(),user.getUserPlace(),user.getIsAdmin(),user.getStatus(),user.getUserId()};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int deleteUser(int id) {
		String sql="delete from t_user where userId=?";
		Object[]param={id};
		return exceuteUpdate(sql, param);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByUserInfo(User user, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

}
