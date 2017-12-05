package com.etcxm.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
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
import com.etcxm.Dao.ProductDao;
import com.etcxm.Dao.PropertyDao;
import com.etcxm.Entity.Category;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductImg;
import com.etcxm.Entity.ProductValue;
import com.etcxm.Entity.Property;
import com.etcxm.Utils.StringUtil;

@WebServlet("/product")
@MultipartConfig
public class productServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDao dao = new ProductDao();
	private CategoryDao dao1 = new CategoryDao();
	private PropertyDao dao2 = new PropertyDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String cmd = req.getParameter("cmd");
		if (StringUtil.hasLength(cmd)) {
			if (cmd.equals("addProduct")) {
				addProduct(req, resp);
			}
			if (cmd.equals("deleteProduct")) {
				deleteProduct(req, resp);
			}
			if (cmd.equals("showProduct")) {
				showProduct(req, resp);
			}
			if (cmd.equals("editProduct")) {
				editProduct(req, resp);
			}
			if (cmd.equals("showProductImg")) {
				showProductImg(req, resp);
			}
			if (cmd.equals("addProductImg")) {
				addProductImg(req, resp);
			}
			if (cmd.equals("deleteProductImg")) {
				deleteProductImg(req, resp);
			}
			if (cmd.equals("showProductValue")) {
				showProductValue(req, resp);
			}
			if (cmd.equals("editProductValue")) {
				editProductValue(req, resp);
			}

		} else {
			list(req, resp);
		}
	}

	protected void showProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String editId = req.getParameter("editId");
		String currentPage = req.getParameter("currentPage");
		String c = req.getParameter("c");
		try {
			Product product = dao.queryProductById(Integer.valueOf(editId));
			Category category = dao1.queryById(Integer.valueOf(c));
			req.setAttribute("p", product);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("c", category);
			req.getRequestDispatcher("/admin/editProduct.jsp").forward(req,
					resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void addProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cId = req.getParameter("cId");
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String price = req.getParameter("price");
		String discountPrice = req.getParameter("discountPrice");
		String stock = req.getParameter("stock");
		Product p = new Product();
		p.setCID(BigDecimal.valueOf(Long.valueOf(cId)));
		p.setNAME(name);
		p.setTITLE(title);
		p.setPRICE(BigDecimal.valueOf(Double.valueOf(price)));
		p.setDISCOUNTPRICE(BigDecimal.valueOf(Double.valueOf(discountPrice)));
		p.setSTOCK(BigDecimal.valueOf(Long.valueOf(stock)));
		p.setCREATEDATE(new java.sql.Timestamp(new Date().getTime()));
		try {
			boolean result = dao.addProduct(p);
			if (result) {
				System.out.println("成功添加商品");
				resp.sendRedirect("/Tiger/product?cId=" + cId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void deleteProduct(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String deleteId = req.getParameter("deleteId");
		String currentPage = req.getParameter("currentPage");
		String cid = req.getParameter("cid");
		try {
			boolean result = dao.deleteProductById(Integer.valueOf(deleteId));
			if (result) {
				System.out.println("删除商品成功");
				resp.sendRedirect("/Tiger/product?cId=" + cid + "&currentPage="
						+ currentPage);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void editProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String cid = req.getParameter("cid");
		String currentPage = req.getParameter("currentPage");
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String price = req.getParameter("price");
		String discountprice = req.getParameter("discountprice");
		String stock = req.getParameter("stock");
		Product p = new Product();
		p.setID(BigDecimal.valueOf(Long.valueOf(id)));
		p.setNAME(name);
		p.setPRICE(BigDecimal.valueOf(Double.valueOf(price)));
		p.setDISCOUNTPRICE(BigDecimal.valueOf(Double.valueOf(discountprice)));
		p.setTITLE(title);
		p.setSTOCK(BigDecimal.valueOf(Double.valueOf(stock)));
		try {
			boolean result = dao.updateProduct(p);
			if (result) {
				System.out.println("更新成功");
				resp.sendRedirect(("/Tiger/product?cId=" + cid
						+ "&currentPage=" + currentPage));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void showProductImg(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pId");
		try {
			List<ProductImg> list = dao.queryProductImg(Integer.valueOf(pId));
			Product p = dao.queryProductById(Integer.valueOf(pId));
			BigDecimal cid = p.getCID();
			Category c = dao1.queryById(Integer.valueOf(cid.toString()));
			req.setAttribute("c", c);
			req.setAttribute("p", p);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/admin/productImg.jsp")
					.forward(req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void addProductImg(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String pid = req.getParameter("pid");
		System.out.println(pid);
		try {
			boolean result = dao.addProductImg(Integer.valueOf(pid), type);
			if (result) {
				System.out.println("成功添加图片");
				List<ProductImg> list = dao.queryProductImgDesc();
				BigDecimal id = list.get(0).getID();
				String realPath = req.getServletContext().getRealPath(
						"/img/productSingle");
				if (type.equals("detail")) {
					realPath = req.getServletContext().getRealPath(
							"/img/productDetail");
				}

				Part part = req.getPart("filepath");
				// 获取请求头参数
				String header = part.getHeader("Content-Disposition");
				// 截取filename
				String substringBetween = org.apache.commons.lang3.StringUtils
						.substringBetween(header, "filename=\"", "\"");
				String extension = FilenameUtils.getExtension(substringBetween);
				part.write(realPath + "/" + id + "." + extension);
				System.out.println("图片上传成功");
				resp.sendRedirect("/Tiger/product?cmd=showProductImg&pId="
						+ pid);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void deleteProductImg(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String deleteId = req.getParameter("deleteId");
		String pid = req.getParameter("pid");
		try {
			boolean result = dao.deleteProductImg(Integer.valueOf(deleteId));
			if (result) {
				System.out.println("删除图片成功");
				resp.sendRedirect("/Tiger/product?cmd=showProductImg&pId="
						+ pid);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void showProductValue(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pId");
		String cId = req.getParameter("c");
		String pName = req.getParameter("pName");
		try {
			List<ProductValue> list = dao.queryProductValueByPID(Integer
					.valueOf(pId));
			Category c = dao1.queryById(Integer.valueOf(cId));
			req.setAttribute("list", list);
			req.setAttribute("pName", pName);
			req.setAttribute("c", c);
			req.getRequestDispatcher("/admin/editProductValue.jsp").forward(
					req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void editProductValue(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String pvid = req.getParameter("pvid");
		String value = req.getParameter("value");
		value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
		String name = req.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String pid = req.getParameter("pid");
		String cid = req.getParameter("cid");
		try {
			if (StringUtil.hasLength(pvid)) {
				boolean result = dao.updateProductValue(Integer.valueOf(pvid),
						value);
				if (result) {
					System.out.println("更新成功");
				}
			} else {
				Property p = dao2.queryBycidAndname(Integer.valueOf(cid), name);
				boolean result = dao.addProductValue(Integer.valueOf(pid),
						Integer.valueOf(p.getID().toString()), value);

				if (result) {
					System.out.println("插入成功");
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
			List<Product> list = dao.queryProductlimit(currentPage,
					Integer.valueOf(cId));
			List<String> imgList = dao.queryProductImgIdByList(list);
			List<Product> queryProduct = dao.queryProduct();
			// 商品图片
			Category c = dao1.queryById(Integer.valueOf(cId));
			int total = queryProduct.size();
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
			req.setAttribute("imgList", imgList);
			req.setAttribute("c", c);
			req.getRequestDispatcher("/admin/product.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
