package com.etcxm.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Dao.CategoryDao;
import com.etcxm.Dao.ProductDao;
import com.etcxm.Entity.Category;
import com.etcxm.Entity.Product;

@WebServlet("/home")
public class homeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryDao dao=new CategoryDao();
	private ProductDao dao1=new ProductDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		try {
			List<Category> clist = dao.queryCategory();
			List<Product> list1;
			List<List<Product>> plist = new ArrayList<List<Product>>();
			for (Category c : clist) {
				 list1 = dao1.queryProductByCId(Integer.valueOf(c.getId().toString()));
				 plist.add(list1);
			}
			req.setAttribute("clist", clist);
			req.setAttribute("plist", plist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	

}
