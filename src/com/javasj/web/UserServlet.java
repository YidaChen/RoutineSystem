package com.javasj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasj.entity.User;
import com.javasj.service.UserService;
import com.javasj.service.impl.UserServiceImpl;
import com.javasj.util.DateUtil;
import com.javasj.util.Page;
import com.javasj.util.StringUtil;

public class UserServlet extends HttpServlet {
	UserService userService=new UserServiceImpl();
	private static final long serialVersionUID = 1L;
    public UserServlet() {
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
			userLogin(request,response);
			break;
		case 2:
			userRegist(request,response);
			break;
		case 5:
			userListByUserInfo(request,response);
			break;
		default:
			break;
		}
	}
	/**
	* 
	* @Title: userLogin 
	* @Description: TODO(用户登陆) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	*/
	private void userLogin(HttpServletRequest request, HttpServletResponse response) {
		User user=userService.userLogin(request.getParameter("username"), request.getParameter("password"));
		if(user!=null){
			request.getSession().setAttribute("userstatus", user);
			if(user.getIsAdmin()==1)
				try {
					response.sendRedirect("manage.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
			else
				try {
					response.sendRedirect("index.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else{
			try {
				request.setAttribute("erroinfo", "用户名或密码错误");
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	* 
	* @Title: userRegist 
	* @Description: TODO(用户注册) 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	*/
	private void userRegist(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("username");
		User user=userService.findUserByUserName(username);
		if(user!=null){
			//用户已经存在，不允许用户注册
			try {
				request.setAttribute("erroinfo", "用户名已存在");
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			user=new User(username, request.getParameter("password"), Integer.parseInt(request.getParameter("usersex")), DateUtil.fmtStrToDate(request.getParameter("userbirthday")), request.getParameter("phonenumber"), request.getParameter("userplace"), 2);
			if(userService.addUser(user)>0){
				try {
					request.setAttribute("erroinfo", "注册成功");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			else{
				try {
					request.setAttribute("erroinfo", "系统错误");
					request.getRequestDispatcher("result.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private void userListByUserInfo(HttpServletRequest request, HttpServletResponse response) {
		User user=new User();
		String username=request.getParameter("username");
		String userplace=request.getParameter("userplace");
		String usersex=request.getParameter("usersex");
		String status=request.getParameter("ststus");
		String isadmin=request.getParameter("isadmin");
		String userbirthday=request.getParameter("userbirthday");
		String jointime=request.getParameter("jointime");
		user.setUserName(StringUtil.isNull(username)?username:null);
		user.setUserPlace(StringUtil.isNull(userplace)?userplace:null);
		user.setIsAdmin(StringUtil.isNull(isadmin)?Integer.parseInt(isadmin):0);
		user.setUserSex(StringUtil.isNull(usersex)?Integer.parseInt(usersex):0);
		user.setStatus(StringUtil.isNull(status)?Integer.parseInt(status):0);
		user.setUserBirthday(StringUtil.isNull(userbirthday)?DateUtil.fmtStrToDate(userbirthday):null);
		user.setJoinTime(StringUtil.isNull(jointime)?DateUtil.fmtStrToDate(jointime):null);
		Page page=new Page();
		String index=request.getParameter("index");
		String pagesize=request.getParameter("pagesize");
		page.setIndex(StringUtil.isNull(index)?Integer.parseInt(index):1);
		page.setPagesize(StringUtil.isNull(pagesize)?Integer.parseInt(pagesize):10);
		List<User> listUser=userService.findUserByUserInfo(user, page);
		page.setAllcount(userService.findUserCountByUserInfo(user));
		page.setAllpage(page.getAllcount()%page.getPagesize()==0?page.getAllcount()/page.getPagesize():(page.getAllcount()/page.getPagesize())+1);
		System.out.println(listUser);
	}
}
