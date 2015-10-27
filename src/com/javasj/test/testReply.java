package com.javasj.test;

import java.util.List;

import org.junit.Test;

import com.javasj.entity.Message;
import com.javasj.entity.Reply;
import com.javasj.entity.User;
import com.javasj.service.ReplyService;
import com.javasj.service.impl.ReplyServiceImpl;
import com.javasj.util.Page;

public class testReply {
	@Test
	public void addReply(){
		ReplyService replyService=new ReplyServiceImpl();
		Message message=new Message();
		message.setMessageId(1);
		User user =new User();
		user.setUserId(1);
		Reply reply=new Reply();
		reply.setMessage(message);
		reply.setUser(user);
		reply.setReplyContext("回复测试消息");
		int result=replyService.addReply(reply);
		System.out.println(result);
	}
	@Test
	public void updateReply(){
		ReplyService replyService=new ReplyServiceImpl();
		Reply reply=new Reply();
		reply.setReplyId(1);
		reply.setReplyContext("回复测试消息");
		int result=replyService.updateReply(reply);
		System.out.println(result);
	}
	@Test
	public void deleteReply(){
		ReplyService replyService=new ReplyServiceImpl();
		int result=replyService.deleteReply(3);
		System.out.println(result);
	}
	@Test
	public void findReplyByMessageId(){
		ReplyService replyService=new ReplyServiceImpl();
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		List<Reply> listReply=replyService.findReplyByMessageId(1, page);
		System.out.println(listReply);
	}
	@Test
	public void findCountByMessaggeId(){
		ReplyService replyService=new ReplyServiceImpl();
		int result=replyService.findCountByMessaggeId(1);
		System.out.println(result);
	}
}
