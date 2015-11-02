package com.javasj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasj.entity.Message;
import com.javasj.entity.Reply;
import com.javasj.entity.User;
import com.javasj.service.ReplyService;
import com.javasj.service.impl.ReplyServiceImpl;
public class ReplyServlet extends HttpServlet {
	ReplyService replyService=new ReplyServiceImpl();
	private static final long serialVersionUID = 1L;
    public ReplyServlet() {
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
			publicReply(request,response);
			break;
		case 2:
			break;
		default:
			break;
		}
	}
	/**
	* @Title: publicReply 
	* @Description: TODO(发布回复) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void publicReply(HttpServletRequest request, HttpServletResponse response) {
		User user=(User) request.getSession().getAttribute("userstatus");
		if(user!=null){
			Reply reply=new Reply();
			reply.setUser(user);
			reply.setReplyContext(request.getParameter("replycontent"));
			Message message=new Message();
			message.setMessageId(Integer.parseInt(request.getParameter("messageid")));
			reply.setMessage(message);
			if(replyService.addReply(reply)>0){
				try {
					request.setAttribute("erroinfo", "回复成功");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("erroinfo", "回复成功");
				try {
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			request.setAttribute("erroinfo", "对不起，您未登录，无权回复");
			try {
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
