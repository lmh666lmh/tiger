package com.etcxm.Servlet;

import java.io.IOException;
import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Dao.CategoryDao;
import com.etcxm.Entity.Category;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductQueryObject;
import com.etcxm.Utils.StringUtil;


@WebServlet("/query")
public class QueryServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		CategoryDao dao = new CategoryDao();
		
		
		
		String name = req.getParameter("strName");
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
	
		
		
		
		try {
			//List<Product> list = dao.queryAllproducts();
			ProductQueryObject op = new ProductQueryObject();
			op.setTITLE(name);
			if(StringUtil.hasLength(minPrice)){
				op.setMinPrice(Double.valueOf(minPrice));
			}
			if(StringUtil.hasLength(maxPrice)){
				op.setMaxPrice(Double.valueOf(maxPrice));
			}
			
			List<Product> products = dao.query(op);
			
			List<Category> queryCategory = dao.queryCategory();
			System.out.println(products);
	
			
			//把op对象放到作用域  共享数据
			req.setAttribute("op", op);
			req.setAttribute("list", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.响应请求转发
				req.getRequestDispatcher("Query.jsp").forward(
						req, resp);
		
	}

}
