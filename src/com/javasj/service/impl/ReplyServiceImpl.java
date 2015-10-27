package com.javasj.service.impl;

import java.util.List;

import com.javasj.dao.ReplyDao;
import com.javasj.dao.impl.ReplyDaoImpl;
import com.javasj.entity.Reply;
import com.javasj.service.ReplyService;
import com.javasj.util.Page;

public class ReplyServiceImpl implements ReplyService {
	ReplyDao replyDao=new ReplyDaoImpl();
	@Override
	public int addReply(Reply reply) {
		return replyDao.addReply(reply);
	}

	@Override
	public int updateReply(Reply reply) {
		return replyDao.updateReply(reply);
	}

	@Override
	public int deleteReply(int replyId) {
		return replyDao.deleteReply(replyId);
	}

	@Override
	public List<Reply> findReplyByMessageId(int messageId, Page page) {
		return replyDao.findReplyByMessageId(messageId, page);
	}

	@Override
	public int findCountByMessaggeId(int messageId) {
		return replyDao.findCountByMessaggeId(messageId);
	}

}
