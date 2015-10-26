package com.javasj.dao;

import java.util.List;

import com.javasj.entity.User;
import com.javasj.util.Page;
/**
* 
* @ClassName: UserDao 
* @Description: TODO(用户管理的接口) 
* @author 王小圈 
* @date 2015年10月26日 下午10:52:10 
*
*/
public interface UserDao {
	/**
	* @Title: addUser 
	* @Description: TODO(添加一个用户) 
	* @param @param user  用户
	* @return void    返回类型 
	* @throws
	*/
	public void addUser(User user);
	/**
	* @Title: updateUser 
	* @Description: TODO(更新用户) 
	* @param @param user 用户
	* @return void    返回类型 
	* @throws
	*/
	public void updateUser(User user);
	/**
	* @Title: deleteUser 
	* @Description: TODO(删除一个用户) 
	* @param @param id  根据用户编号删除
	* @return void    返回类型 
	* @throws
	*/
	public void deleteUser(int id);
	/**
	* @Title: findUserById 
	* @Description: TODO(根据用户编号查找一个用户) 
	* @param @param id 用户编号
	* @param @return  一个用户 
	* @return User    返回类型 
	* @throws
	 */
	public User findUserById(int id);
	/**
	* @Title: findAllUser 
	* @Description: TODO(分页查询全部用户) 
	* @param @param page 分页查询
	* @param @return    返回用户集合 
	* @return List<User>    返回类型 
	* @throws
	 */
	public List<User> findAllUser(Page page);
	/**
	* @Title: findUserByUserInfo 
	* @Description: TODO(根据用户用户所传来的信息来分页查找用户) 
	* @param @param user 用户对象
	* @param @param page 分页对象
	* @param @return    返回用户列表
	* @return List<User>   返回类型 
	* @throws
	 */
	public List<User> findUserByUserInfo(User user,Page page);
}
