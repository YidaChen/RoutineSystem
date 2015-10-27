package com.javasj.test;


import org.junit.Test;

import com.javasj.entity.Criticism;
import com.javasj.entity.Message;
import com.javasj.entity.User;
import com.javasj.service.CriticismService;
import com.javasj.service.impl.CriticismServiceImpl;

public class testCriticism {
	@Test
	public void addCriticism(){
		CriticismService criticismService=new CriticismServiceImpl();
		Criticism criticism=new Criticism();
		criticism.setCrititcismContent("测试批复");
		Message message=new Message();
		message.setMessageId(2);
		criticism.setMessage(message);
		User user=new User();
		user.setUserId(1);
		criticism.setUser(user);
		int result=criticismService.addCriticism(criticism);
		System.out.println(result);
	}
	@Test
	public void findCriticismByMessageId(){
		CriticismService criticismService=new CriticismServiceImpl();
		Criticism criticism=criticismService.findCriticismByMessageId(1);
		System.out.println(criticism);
	}
}
