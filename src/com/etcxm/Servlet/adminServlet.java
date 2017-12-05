package com.etcxm.Servlet;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.etcxm.Dao.CategoryDao;
import com.etcxm.Entity.Category;
import com.etcxm.Utils.StringUtil;

@WebServlet("/admin")
@MultipartConfig
public class adminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryDao dao = new CategoryDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String cmd = req.getParameter("cmd");
		if (StringUtil.hasLength(cmd)) {
			if (cmd.equals("addCategory")) {
				addCategory(req, resp);
			}if(cmd.equals("deleteCategory")){
				deleteCategory(req, resp);
			}if(cmd.equals("showCategory")){
				showCategory(req, resp);
			}if(cmd.equals("editCategory")){
				editCategory(req, resp);
			}
		} else {
			list(req, resp);
		}
	}

	protected void addCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		// 添加到数据库
		try {
			boolean result = dao.addCategory(name);
			if (result) {
				System.out.println("新增成功");
				Category category = dao.queryByName(name);
				BigDecimal id = category.getId();
				String realPath = req.getServletContext().getRealPath("/img");
				Part part = req.getPart("filepath");
				// 获取请求头参数
				String header = part.getHeader("Content-Disposition");
				// 截取filename
				String substringBetween = org.apache.commons.lang3.StringUtils
						.substringBetween(header, "filename=\"", "\"");
				String extension = FilenameUtils.getExtension(substringBetween);
				
				part.write(realPath+"/c"+id+"."+extension);
				System.out.println("图片上传成功");
				resp.sendRedirect("/Tiger/admin");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void deleteCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 String deleteId = req.getParameter("deleteId");
		 String currentPage = req.getParameter("currentPage");
		 try {
			boolean result = dao.deleteCategory(Integer.valueOf(deleteId));
			if(result){
				System.out.println("删除成功");
				resp.sendRedirect("/Tiger/admin?currentPage="+currentPage);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void showCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   String editId = req.getParameter("editId");
		   String currentPage = req.getParameter("currentPage");
		   req.setAttribute("currentPage", currentPage);
		   try {
			Category category = dao.queryById(Integer.valueOf(editId));
			req.setAttribute("c", category);
			req.getRequestDispatcher("/admin/editCategory.jsp").forward(req, resp);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void editCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String currentPage = req.getParameter("currentPage");
		String realPath = req.getServletContext().getRealPath("/img");
		File file=new File(realPath+"/c"+id+".jpg");
		try {
			boolean result = dao.updateCategory(name, Integer.valueOf(id));
			if(result){
				Part part = req.getPart("filepath");
				// 获取请求头参数
				String header = part.getHeader("Content-Disposition");
				// 截取filename
				String substringBetween = org.apache.commons.lang3.StringUtils
						.substringBetween(header, "filename=\"", "\"");
				String extension = FilenameUtils.getExtension(substringBetween);
				//替换文件
				if(StringUtil.hasLength(substringBetween)){
				file.delete();
				part.write(realPath+"/c"+id+"."+extension);}
				System.out.println("修改成功");
				resp.sendRedirect("/Tiger/admin?currentPage="+currentPage);
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
		int currentPage = 1;
		if (StringUtil.hasLength(req.getParameter("currentPage"))) {
			currentPage = Integer.valueOf(req.getParameter("currentPage"));
		}
		try {
			 List<Category> list = dao.queryCategorylimit(currentPage);
			// 总共多少条数据
			List<Category> queryCategory = dao.queryCategory();
			int total = queryCategory.size();
			int pageTotal;
			if(total%5==0){
				 pageTotal=total/5;
			}else{
				 pageTotal=total/5+1;
			}
			com.etcxm.Utils.PageIndex pageIndex = com.etcxm.Utils.PageIndex
					.getPageIndex(5, currentPage,pageTotal);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("pageIndex", pageIndex);
			req.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/admin/category.jsp").forward(req, resp);
	}

}
