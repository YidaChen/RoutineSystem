package com.javasj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.javasj.dao.BaseDao;
import com.javasj.dao.CriticismDao;
import com.javasj.entity.Criticism;
import com.javasj.entity.Message;
import com.javasj.entity.User;

public class CriticismDaoImpl extends BaseDao implements CriticismDao {

	@Override
	public int addCriticism(Criticism criticism) {
		String sql="insert into t_criticism (criticismContent,criticismTime,userId,messageId) values(?,?,?,?)";
		Object[]param={criticism.getCrititcismContent(),new Date(),criticism.getUser().getUserId(),criticism.getMessage().getMessageId()};
		return exceuteUpdate(sql, param);
	}

	@Override
	public Criticism findCriticismByMessageId(int messageId) {
		String sql="select * from t_criticism cm,t_user us,t_message msg where cm.userId=us.userId and msg.messageId=cm.messageId and cm.messageId=?";
		Criticism criticism =null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,messageId);
			rs =pstmt.executeQuery();
			if (rs.next()) {
				criticism =new Criticism();
				criticism.setCriticismId(rs.getInt("criticismId"));
				criticism.setCrititcismContent(rs.getString("criticismContent"));
				criticism.setCriticismTime(rs.getDate("criticismTime"));
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
				criticism.setUser(user);
				criticism.setMessage(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return criticism;
	}

}
