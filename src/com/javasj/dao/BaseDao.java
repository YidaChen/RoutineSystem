package com.javasj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
* 
* @ClassName: BaseDao 
* @Description: TODO(数据库连接、关闭、查找、更新基本操作) 
* @author 王小圈 
* @date 2015年10月26日 下午11:30:01 
*
 */
public class BaseDao {
	/**
	 * 数据库驱动
	 */
	private static final String DRIVER = "com.mysql.jdbc.Driver" ;
	/**
	 * 数据库连接地址
	 */
    private static final String URL = "jdbc:mysql://localhost:3306/db_routinemanage";
    /**
     * 用户名
     */
    private static final String USER = "root" ;
    /**
     * 密码
     */
    private static final String PASSWORD = "123456";
    Connection conn = null;
    /**
	 * 获取数据库连接对象。
	 */
	protected Connection getConnection() {
		if(conn!=null){
			// 获取连接并捕获异常
			try {
				if(conn.isClosed())
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();// 异常处理
			}
		}
		return conn;// 返回连接对象
	}
	/**
	* @Title: closeAll 
	* @Description: TODO(关闭所有) 
	* @param @param conn 数据库连接对象
	* @param @param stmt Statement对象
	* @param @param rs 返回结果集
	* @param @param pstmt  预编译对象
	* @return void    返回类型 
	* @throws
	 */
	protected void closeAll(Connection conn, Statement stmt, ResultSet rs,PreparedStatement pstmt) {
		// 若结果集对象不为空，则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//若预编译对象不为空，则关闭
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空，则关闭
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空，则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增、删、改的操作
	 * @param sql 预编译的 SQL 语句          
	 * @param param 预编译的 SQL 语句中的'?'参数的字符串数组          
	 * @return 影响的行数
	 */
	protected int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, null, null, pstmt);
		}
		return num;
	}
}
