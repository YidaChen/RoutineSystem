package com.javasj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasj.entity.Message;
import com.javasj.service.MessageService;
import com.javasj.service.impl.MessageServiceImpl;
import com.javasj.util.Page;

public class IndexServlet extends HttpServlet {
	MessageService messageService=new MessageServiceImpl();
	private static final long serialVersionUID = 1L;
    public IndexServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page page=new Page();
		page.setIndex(1);
		page.setPagesize(10);
		List<Message> messageList=messageService.findAllMessage(page);
		if(messageList!=null){
			request.setAttribute("messagelist", messageList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
