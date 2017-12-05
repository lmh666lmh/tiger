package com.etcxm.Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Utils.BaseDao;




import com.etcxm.Utils.BaseDao;
import com.etcxm.Utils.JDBCUtils;



//与ajax实现异步校验的servlet
@WebServlet("/NameExistServlet")
public class NameExistServlet extends HttpServlet{


	/**
	 * 
	 */
    public NameExistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	private static final long serialVersionUID = 1L;
	
	@Override
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	
		doPost(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		 
  		
  	
		try{
				
			Connection conn =(Connection) BaseDao.getConn();
	  		String username=req.getParameter("val");
	  		System.out.println(username);
			
			Statement stmt= (Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery("select*from T_USER where username="+"'"+username+"'");
			System.out.println("get "+username);
			while(rs.next()){
				String dName=rs.getString("username");
				if(dName.equals(username)){
					System.out.print("false");
					resp.getWriter().print(false);
				
				}
				else{
					System.out.print("true");
					resp.getWriter().print(true);
					
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			}
	}
}

