package com.etcxm.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.etcxm.Entity.Category;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.User;

import com.etcxm.Entity.User;

import com.etcxm.Utils.BaseDao;
import com.etcxm.Utils.JDBCUtils;
import com.etcxm.Utils.StringUtil;

import com.etcxm.Utils.BaseDao;
import com.etcxm.Utils.StringUtil;

import com.sun.org.apache.regexp.internal.recompile;

public class UserDao {
	//创建一个JDBC
	private JDBCUtils util = new JDBCUtils();

	public UserDao() {
		util.getConnection();
	}
	
//	登录
	
public User checkLogin(String username,String password) throws Exception{
			String sql = "SELECT * FROM t_user WHERE username = ? AND password = ?";
			List<Object> params = new ArrayList<Object>();
			params.add(username);
			params.add(password);
			User user = util.findSimpleRefResult(sql, params, User.class);
			util.releaseConn();
			return user;
		}
		
		

	public List<User> checkLogin1() throws Exception{
		
		String sql="SELECT * FROM T_USER ";
		List<Object> params = new ArrayList<Object>();
	
		@SuppressWarnings("unchecked")
		List<User> users =(List<User>) BaseDao.select(sql, User.class, null);
		return users;
	}
	


	
}
