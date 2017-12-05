package com.etcxm.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Dao.CategoryDao;
import com.etcxm.Dao.PropertyDao;
import com.etcxm.Entity.Category;
import com.etcxm.Entity.Property;
import com.etcxm.Utils.StringUtil;

@WebServlet("/property")
public class propertyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PropertyDao dao = new PropertyDao();
	private CategoryDao dao1 = new CategoryDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String cmd = req.getParameter("cmd");
		if (StringUtil.hasLength(cmd)) {
			if (cmd.equals("addProperty")) {
				addProperty(req, resp);
			}
			if (cmd.equals("deleteProperty")) {
				 deleteProperty(req, resp);
			}
			if (cmd.equals("showProperty")) {
				 showProperty(req, resp);
			}
			if (cmd.equals("editProperty")) {
				 editProperty(req, resp);
			}
		} else {
			list(req, resp);
		}
	}

	protected void addProperty(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cId = req.getParameter("cId");
		String name = req.getParameter("name");
		try {
			boolean result = dao.addProperty(name, Integer.valueOf(cId));
			if(result){
				System.out.println("新增成功");
				resp.sendRedirect("/Tiger/property?cId="+cId);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void deleteProperty(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String deleteId = req.getParameter("deleteId");
		 String currentPage = req.getParameter("currentPage");
		 String cId = req.getParameter("cId");
		 try {
			boolean result = dao.deleteProperty(Integer.valueOf(deleteId));
			if(result){
				System.out.println("删除成功");
				resp.sendRedirect("/Tiger/property?cId="+cId+"&currentPage="+currentPage);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void showProperty(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   String editId = req.getParameter("editId");
		   String currentPage = req.getParameter("currentPage");
		   String cId = req.getParameter("cId");
		   req.setAttribute("currentPage", currentPage);
		   req.setAttribute("cId", cId);
		   try {
			Property property = dao.queryById(Integer.valueOf(editId));
			req.setAttribute("p", property);
			req.getRequestDispatcher("/admin/editProperty.jsp").forward(req, resp);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void editProperty(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String currentPage = req.getParameter("currentPage");
		String cId = req.getParameter("cId");
		try {
			boolean result = dao.updateProperty(name, Integer.valueOf(id));
			if(result){
				System.out.println("修改成功");
				resp.sendRedirect("/Tiger/property?cId="+cId+"&currentPage="+currentPage);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cId = req.getParameter("cId");
		int currentPage = 1;
		if (StringUtil.hasLength(req.getParameter("currentPage"))) {
			currentPage = Integer.valueOf(req.getParameter("currentPage"));
		}
		try {
			List<Property> list = dao.queryPropertylimit(currentPage,
					Integer.valueOf(cId));
			List<Property> queryProperty = dao.queryProperty();
			Category c = dao1.queryById(Integer.valueOf(cId));
			int total = queryProperty.size();
			int pageTotal;
			if (total % 5 == 0) {
				pageTotal = total / 5;
			} else {
				pageTotal = total / 5 + 1;
			}
			com.etcxm.Utils.PageIndex pageIndex = com.etcxm.Utils.PageIndex
					.getPageIndex(5, currentPage, pageTotal);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("pageIndex", pageIndex);
			req.setAttribute("list", list);
			req.setAttribute("c", c);
			req.getRequestDispatcher("/admin/property.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
