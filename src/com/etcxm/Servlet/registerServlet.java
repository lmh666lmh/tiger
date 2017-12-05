package com.etcxm.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Utils.BaseDao;

@WebServlet("/register")
public class registerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) BaseDao.getConn();
		String username1 = req.getParameter("username");
		System.out.println(username1);
		String password = req.getParameter("password");
		System.out.println(password);
		String email = req.getParameter("email");
		System.out.println(email);
		PreparedStatement pst = null;
		try {
			pst = conn
					.prepareStatement("insert into T_USER(username,password,email)values(?,?,?)");
			pst.setString(1, username1);
			pst.setString(2, password);
			pst.setString(3, email);
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("注册成功");
				resp.sendRedirect("/Tiger/home");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
