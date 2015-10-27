package com.javasj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javasj.dao.BaseDao;
import com.javasj.dao.ReplyDao;
import com.javasj.entity.Message;
import com.javasj.entity.Reply;
import com.javasj.entity.User;
import com.javasj.util.Page;

public class ReplyDaoImpl extends BaseDao implements ReplyDao {

	@Override
	public int addReply(Reply reply) {
		String sql="insert into t_reply (replyContent,replyDate,userId,messageId) values(?,?,?,?)";
		Object[]param={reply.getReplyContext(),new Date(),reply.getUser().getUserId(),reply.getMessage().getMessageId()};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int updateReply(Reply reply) {
		String sql="update t_reply set replyContent=?,replyDate=? where replyId=?";
		Object[]param={reply.getReplyContext(),new Date(),reply.getReplyId()};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int deleteReply(int replyId) {
		String sql="delete from t_reply where replyId=?";
		Object[]param={replyId};
		return exceuteUpdate(sql, param);
	}

	@Override
	public List<Reply> findReplyByMessageId(int messageId, Page page) {
		String sql="select * from t_reply rp,t_user us,t_message msg where rp.userId=us.userId and msg.messageId=rp.messageId and rp.messageId=? and replyId limit ?,?";
		List<Reply> listReply =new ArrayList<Reply>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,messageId);
			pstmt.setObject(2,(page.getIndex()-1)*page.getPagesize());
			pstmt.setObject(3,page.getIndex()*page.getPagesize());
			rs =pstmt.executeQuery();
			while (rs.next()) {
				Reply reply =new Reply();
				reply.setReplyId(rs.getInt("replyDate"));
				reply.setReplyContext(rs.getString("replyContent"));
				reply.setReplyDate(rs.getDate("replyDate"));
				Message message=new Message();
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
				reply.setUser(user);
				reply.setMessage(message);
				listReply.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, rs, pstmt);
		}
		return listReply;
	}

	@Override
	public int findCountByMessaggeId(int messageId) {
		int count=0;
		String sql="select count(1) from t_reply where messageId=? ";
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,messageId);
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
