package com.javasj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasj.entity.Message;
import com.javasj.entity.User;
import com.javasj.service.MessageService;
import com.javasj.service.impl.MessageServiceImpl;
import com.javasj.util.Page;
import com.javasj.util.StringUtil;

public class MessageServlet extends HttpServlet {
	MessageService messageService=new MessageServiceImpl();
	private static final long serialVersionUID = 1L;
    public MessageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String optionInfo=request.getParameter("option");
		int option=optionInfo!=null&&!optionInfo.equals("")?Integer.parseInt(optionInfo):0;
		switch (option) {
		case 1:
			publicMessage(request,response);
			break;
		case 2:
			loadMessage(request,response);
			break;
		case 3:
			listMessage(request,response);
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			break;
		}
	}
	/**
	* 
	* @Title: publicMessage 
	* @Description: TODO(发布消息) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	*/
	private void publicMessage(HttpServletRequest request, HttpServletResponse response) {
		User user=(User) request.getSession().getAttribute("userstatus");
		if(user!=null){
			//判断用户登录状态
			Message message=new Message();
			message.setMessageContent(request.getParameter("messagecontent"));
			message.setMessageTitle(request.getParameter("messagetitle"));
			message.setUser(user);
			if(messageService.addMessage(message)>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		}else{
			System.out.println("用户未登录，登录后发布信息");
		}
	}
	/**
	* 
	* @Title: loadMessage 
	* @Description: TODO(加载消息) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void loadMessage(HttpServletRequest request, HttpServletResponse response) {
		String messageid=request.getParameter("messageid");
		int id=StringUtil.isNull(messageid)?Integer.parseInt(messageid):0;
		if(id!=0){
			Message message=messageService.findMessageById(id);
			if(message!=null){
				request.setAttribute("message", message);
				try {
					request.getRequestDispatcher("messageInfo.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private void listMessage(HttpServletRequest request, HttpServletResponse response) {
		Page page=new Page();
		String index=request.getParameter("index");
		String pagesize=request.getParameter("pagesize");
		page.setIndex(StringUtil.isNull(index)?Integer.parseInt(index):1);
		page.setPagesize(StringUtil.isNull(pagesize)?Integer.parseInt(pagesize):10);
		List<Message> messageList=messageService.findAllMessage(page);
		int allcount=messageService.findAllCount();
		page.setAllcount(allcount);
		page.setAllpage((allcount%page.getPagesize()==0)?allcount/page.getPagesize():allcount/page.getPagesize()+1);
		if(messageList!=null){
			request.setAttribute("page", page);
			request.setAttribute("messagelist", messageList);
			try {
				request.getRequestDispatcher("messageList.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
