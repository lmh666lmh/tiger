package com.etcxm.Servlet;


	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import com.etcxm.Utils.JDBCUtils;
	

	/**
	 * Servlet implementation class UserServlet
	 */
	@WebServlet("/UserServlet")
	public class UserServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public UserServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(request,response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			String jvalidateCode=request.getParameter("verifyCode");
			String vvalidateCode=(String) request.getSession().getAttribute("randCheckCode");
			System.out.print(vvalidateCode);
			boolean b=jvalidateCode.equals(vvalidateCode);
			response.getWriter().print(b);
		}		
	}

