package com.javasj.service.impl;

import com.javasj.dao.CriticismDao;
import com.javasj.dao.impl.CriticismDaoImpl;
import com.javasj.entity.Criticism;
import com.javasj.service.CriticismService;

public class CriticismServiceImpl implements CriticismService {
	CriticismDao criticismDao=new CriticismDaoImpl();
	@Override
	public int addCriticism(Criticism criticism) {
		return criticismDao.addCriticism(criticism);
	}

	@Override
	public Criticism findCriticismByMessageId(int messageId) {
		return criticismDao.findCriticismByMessageId(messageId);
	}

}
