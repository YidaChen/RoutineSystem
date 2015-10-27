package com.javasj.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.javasj.entity.Message;
import com.javasj.entity.User;
import com.javasj.service.MessageService;
import com.javasj.service.impl.MessageServiceImpl;
import com.javasj.util.Page;

public class TestMessage {
	@Test
	public void addMessage(){
		MessageService messageService=new MessageServiceImpl(); 
		User user=new User();
		user.setUserId(1);
		Message message=new Message();
		message.setMessageTitle("测试消息");
		message.setMessageContent("测试内容");
		message.setPublicTime(new Date());
		message.setUser(user);
		int result=messageService.addMessage(message);
		System.out.println(result);
	}
	@Test
	public void updateMessage(){
		MessageService messageService=new MessageServiceImpl(); 
		User user=new User();
		user.setUserId(1);
		Message message=new Message();
		message.setMessageId(2);
		message.setMessageTitle("测试消息修改");
		message.setMessageContent("测试内容修改");
		message.setPublicTime(new Date());
		message.setUser(user);
		int result=messageService.updateMessage(message);
		System.out.println(result);
	}
	@Test
	public void deleteMessage(){
		MessageService messageService=new MessageServiceImpl(); 
		int result=messageService.deleteMessage(4);
		System.out.println(result);
	}
	@Test
	public void findMessageById(){
		MessageService messageService=new MessageServiceImpl(); 
		Message message=messageService.findMessageById(1);
		System.out.println(message);
	}
	@Test
	public void findAllMessage(){
		MessageService messageService=new MessageServiceImpl();
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		List<Message> listmessage=messageService.findAllMessage(page);
		System.out.println(listmessage);
	}
	@Test
	public void findAllMessageCount(){
		MessageService messageService=new MessageServiceImpl();
		int result=messageService.findAllCount();
		System.out.println(result);
	}
	@Test
	public void findAllMessageByMessageInfo(){
		MessageService messageService=new MessageServiceImpl();
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		Message message=new Message();
		message.setMessageContent("测试");
		List<Message> listmessage=messageService.findAllMessageByMessageInfo(page,message);
		System.out.println(listmessage);
	}
	@Test
	public void findAllCountByMessageInfo(){
		MessageService messageService=new MessageServiceImpl();
		Message message=new Message();
		message.setMessageContent("测试");
		int result=messageService.findAllCountByMessageInfo(message);
		System.out.println(result);
	}
}
