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
import com.javasj.service.UserService;
import com.javasj.service.impl.MessageServiceImpl;
import com.javasj.service.impl.UserServiceImpl;
import com.javasj.util.Page;
import com.javasj.util.StringUtil;

public class ManageServlet extends HttpServlet {
	UserService userService=new UserServiceImpl();
	MessageService messageService=new MessageServiceImpl();
	private static final long serialVersionUID = 1L;
    public ManageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user=(User) request.getSession().getAttribute("userstatus");
		if(user!=null){
			if(user.getIsAdmin()==1){
				String optionInfo=request.getParameter("option");
				int option=optionInfo!=null&&!optionInfo.equals("")?Integer.parseInt(optionInfo):0;
				switch (option) {
				case 1:
					listMessage(request, response);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					userDelete(request,response);
					break;
				case 6:
					messageDelete(request,response);
					break;
				default:
					userList(request,response);
					break;
				}
			}else{
				try {
					request.setAttribute("erroinfo", "对不起您无权操作");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			try {
				request.setAttribute("erroinfo", "对不起您无权操作");
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	* 
	* @Title: userList 
	* @Description: TODO(用户列表) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	*/
	private void userList(HttpServletRequest request, HttpServletResponse response) {
		Page page=new Page();
		String index=request.getParameter("index");
		String pagesize=request.getParameter("pagesize");
		page.setIndex(StringUtil.isNull(index)?Integer.parseInt(index):1);
		page.setPagesize(StringUtil.isNull(pagesize)?Integer.parseInt(pagesize):10);
		List<User> listUser=userService.findAllUser(page);
		page.setAllcount(userService.findUserCount());
		page.setAllpage(page.getAllcount()%page.getPagesize()==0?page.getAllcount()/page.getPagesize():(page.getAllcount()/page.getPagesize())+1);
		request.setAttribute("userlist", listUser);
		try {
			request.setAttribute("page", page);
			request.getRequestDispatcher("manage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	* 
	* @Title: userDelete 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	*/
	private void userDelete(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("Id");
		int id=userId!=null&&!userId.equals("")?Integer.parseInt(userId):0;
		if(id!=0){
			if(userService.deleteUser(id)>0){
				try {
					request.setAttribute("erroinfo", "删除成功");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					request.setAttribute("erroinfo", "删除失败,查询该用户是否有发帖或回复");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			try {
				request.setAttribute("erroinfo", "参数错误");
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	* @Title: listMessage 
	* @Description: TODO(消息列表) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
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
				request.getRequestDispatcher("manageMessage.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void messageDelete(HttpServletRequest request, HttpServletResponse response) {
		String messageId=request.getParameter("Id");
		int id=messageId!=null&&!messageId.equals("")?Integer.parseInt(messageId):0;
		if(id!=0){
			int result=messageService.deleteMessage(id);
			if(result>0){
				try {
					request.setAttribute("erroinfo", "删除成功");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					request.setAttribute("erroinfo", "删除失败，请查询该消息下是否有回复消息");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			try {
				request.setAttribute("erroinfo", "参数错误");
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
