package com.javasj.service.impl;

import java.util.List;

import com.javasj.dao.MessageDao;
import com.javasj.dao.impl.MessageDaoImpl;
import com.javasj.entity.Message;
import com.javasj.service.MessageService;
import com.javasj.util.Page;

public class MessageServiceImpl implements MessageService {
	MessageDao messageDao=new MessageDaoImpl();
	@Override
	public int addMessage(Message message) {
		return messageDao.addMessage(message);
	}

	@Override
	public int updateMessage(Message message) {
		return messageDao.updateMessage(message);
	}

	@Override
	public int deleteMessage(int messageId) {
		return messageDao.deleteMessage(messageId);
	}

	@Override
	public Message findMessageById(int messageId) {
		return messageDao.findMessageById(messageId);
	}

	@Override
	public List<Message> findAllMessage(Page page) {
		return messageDao.findAllMessage(page);
	}

	@Override
	public List<Message> findAllMessageByMessageInfo(Page page, Message message) {
		return messageDao.findAllMessageByMessageInfo(page, addSql(message));
	}

	@Override
	public int findAllCount() {
		return messageDao.findAllCount();
	}

	@Override
	public int findAllCountByMessageInfo(Message message) {
		return messageDao.findAllCountByMessageInfo(addSql(message));
	}
	public String addSql(Message message){
		String sql="";
		if(message!=null){
			sql+=message.getMessageTitle()!=null&&!message.getMessageTitle().equals("")?"and messageTitle like '%"+message.getMessageTitle()+"%'":"";
			sql+=message.getMessageContent()!=null&&!message.getMessageContent().equals("")?"and messageContent like '%"+message.getMessageContent()+"%'":"";
			sql+=message.getPublicTime()!=null?"and publicTime <'"+message.getPublicTime()+"'":"";
			sql+=message.getUser()!=null?message.getUser().getUserId()!=0?"and userId ="+message.getUser().getUserId():"":"";
		}
		return sql;
	}
}
