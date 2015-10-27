package com.javasj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javasj.dao.BaseDao;
import com.javasj.dao.MessageDao;
import com.javasj.entity.Message;
import com.javasj.entity.User;
import com.javasj.util.Page;

public class MessageDaoImpl extends BaseDao implements MessageDao {

	@Override
	public int addMessage(Message message) {
		String sql="insert into t_message (messageTitle,messageContent,userId,publicTime) values(?,?,?,?)";
		Object[]param={message.getMessageTitle(),message.getMessageContent(),message.getUser().getUserId(),new Date()};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int updateMessage(Message message) {
		String sql="update t_message set messageTitle=?,messageContent=? where messageId=?";
		Object[]param={message.getMessageTitle(),message.getMessageContent(),message.getMessageId()};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int deleteMessage(int messageId) {
		String sql="delete from t_message where messageId=?";
		Object[]param={messageId};
		return exceuteUpdate(sql, param);
	}

	@Override
	public Message findMessageById(int messageId) {
		String sql="select * from t_message ms,t_user us where ms.userId=us.userId and messageId=?";
		Message message =null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,messageId);
			rs =pstmt.executeQuery();
			if (rs.next()) {
				message =new Message();
				message.setMessageId(rs.getInt("messageId"));
				message.setMessageTitle(rs.getString("messageTitle"));
				message.setMessageContent(rs.getString("messageContent"));
				message.setPublicTime(rs.getDate("publicTime"));
				User user=new User();
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
				message.setUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return message;
	}

	@Override
	public List<Message> findAllMessage(Page page) {
		String sql="select * from t_message ms,t_user us where ms.userId=us.userId and messageId limit ?,?";
		List<Message> listmessage =new ArrayList<Message>();
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
				Message message =new Message();
				message.setMessageId(rs.getInt("messageId"));
				message.setMessageTitle(rs.getString("messageTitle"));
				message.setMessageContent(rs.getString("messageContent"));
				message.setPublicTime(rs.getDate("publicTime"));
				User user=new User();
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
				message.setUser(user);
				listmessage.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return listmessage;
	}

	@Override
	public List<Message> findAllMessageByMessageInfo(Page page, String addsql) {
		String sql="select * from t_message ms,t_user us where ms.userId=us.userId ";
		sql+=addsql;
		sql+=" and messageId limit ?,?";
		List<Message> listmessage =new ArrayList<Message>();
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
				Message message =new Message();
				message.setMessageId(rs.getInt("messageId"));
				message.setMessageTitle(rs.getString("messageTitle"));
				message.setMessageContent(rs.getString("messageContent"));
				message.setPublicTime(rs.getDate("publicTime"));
				User user=new User();
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
				message.setUser(user);
				listmessage.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return listmessage;
	}

	@Override
	public int findAllCount() {
		int count=0;
		String sql="select count(1) from t_message";
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
	public int findAllCountByMessageInfo(String addsql) {
		int count=0;
		String sql="select count(1) from t_message where 1=1 ";
		sql+=addsql;
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

}
