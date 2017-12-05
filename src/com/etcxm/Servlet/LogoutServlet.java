package com.etcxm.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	 //1.注销
    	req.getSession().invalidate();
    	//2.跳转
    	resp.sendRedirect("/Tiger/home");
    }
}
