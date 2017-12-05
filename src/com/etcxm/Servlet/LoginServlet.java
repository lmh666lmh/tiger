package com.etcxm.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Dao.UserDao;
import com.etcxm.Entity.User;
import com.etcxm.Utils.StringUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("注册");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String randomCode = req.getParameter("verifyCode");
		System.out.println("-------"+username);
		System.out.println("-------"+password);
		String sessionRandomCode = (String)req.getSession().getAttribute("randCheckCode");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		try {
			User user = dao.checkLogin(username, password);
	
				
				System.out.println(user);
			if(!StringUtil.hasLength(randomCode) || !StringUtil.hasLength(sessionRandomCode) ||!randomCode.equals(sessionRandomCode)){
					System.out.println(randomCode);
//					out.write("验证码错误");
					System.out.println("验证码错误");
		}else if(user==null){
				out.write("用户名或密码错误"); 
			System.out.println("用户名或密码错误");
					}else{
                	out.write("登录成功");
						System.out.println("登录成功");
					req.getSession().setAttribute("CURRENT_USER", user);
					 req.getRequestDispatcher("/home").forward(req,resp);
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}

}





