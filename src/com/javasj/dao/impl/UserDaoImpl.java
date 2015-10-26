package com.javasj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javasj.dao.BaseDao;
import com.javasj.dao.UserDao;
import com.javasj.entity.User;
import com.javasj.util.MD5Util;
import com.javasj.util.Page;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int addUser(User user) {
		String sql="insert into t_user (userName,password,userSex,userBirthDay,userPhoneNumber,userPlace,isAdmin,joinTime,status) values(?,?,?,?,?,?,?,?,?)";
		Object[]param={user.getUserName(),MD5Util.md5(user.getPassword()),user.getUserSex(),user.getUserBirthday(),user.getUserPhoneNumber(),user.getUserPlace(),user.getIsAdmin(),new Date(),1};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int updateUser(User user) {
		String sql="update t_user set userName=?,password=?,userSex=?,userBirthDay=?,userPhoneNumber=?,userPlace=?,isAdmin=?,status=? where userId=?";
		Object[]param={user.getUserName(),MD5Util.md5(user.getPassword()),user.getUserSex(),user.getUserBirthday(),user.getUserPhoneNumber(),user.getUserPlace(),user.getIsAdmin(),user.getStatus(),user.getUserId()};
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
		String sql="select * from t_user where userId=?";
		User user =null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,id);
			rs =pstmt.executeQuery();
			if (rs.next()) {
				user =new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setUserSex(rs.getInt("userSex"));
				user.setUserBirthday(rs.getDate("userBirthDay"));
				user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
				user.setUserPlace(rs.getString("userPlace"));
				user.setJoinTime(rs.getDate("joinTime"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return user;
	}

	@Override
	public List<User> findAllUser(Page page) {
		String sql="select * from t_user where userId limit ?,?";
		List<User> userlist=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,(page.getIndex()-1)*page.getPagesize());
			pstmt.setObject(2,page.getIndex()*page.getPagesize());
			rs =pstmt.executeQuery();
			while (rs.next()) {
				User user =new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setUserSex(rs.getInt("userSex"));
				user.setUserBirthday(rs.getDate("userBirthDay"));
				user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
				user.setUserPlace(rs.getString("userPlace"));
				user.setJoinTime(rs.getDate("joinTime"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setStatus(rs.getInt("status"));
				userlist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return userlist;
	}

	@Override
	public List<User> findUserByUserInfo(User userinfo, Page page) {
		String sql="select * from t_user where 1=1 ";
		sql+=addSql(userinfo);
		sql+=" and userId limit ?,?";
		List<User> userlist=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,(page.getIndex()-1)*page.getPagesize());
			pstmt.setObject(2,page.getIndex()*page.getPagesize());
			rs =pstmt.executeQuery();
			while (rs.next()) {
				User user =new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setUserSex(rs.getInt("userSex"));
				user.setUserBirthday(rs.getDate("userBirthDay"));
				user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
				user.setUserPlace(rs.getString("userPlace"));
				user.setJoinTime(rs.getDate("joinTime"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setStatus(rs.getInt("status"));
				userlist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return userlist;
	}

	@Override
	public int findUserCount() {
		int count=0;
		String sql="select count(1) from t_user";
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return count;
	}

	@Override
	public int findUserCountByUserInfo(User user) {
		int count=0;
		String sql="select count(1) from t_user where 1=1 ";
		sql+=addSql(user);
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return count;
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
