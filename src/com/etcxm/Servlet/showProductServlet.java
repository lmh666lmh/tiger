package com.etcxm.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Dao.ProductDao;
import com.etcxm.Dao.PropertyDao;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductImg;
import com.etcxm.Entity.ProductValue;
import com.etcxm.Utils.StringUtil;

@WebServlet("/showproduct")
public class showProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDao dao = new ProductDao();
	private PropertyDao dao1 = new PropertyDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String cmd = req.getParameter("cmd");
		if (StringUtil.hasLength(cmd)) {
			if (cmd.equals("cproduct")) {
				cproduct(req, resp);
			} else if (cmd.equals("product")) {
				product(req, resp);
			} else if (cmd.equals("search")) {
				search(req, resp);
			}
		}
	}

	protected void cproduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cid = req.getParameter("cid");
		try {
			List<Product> list = dao.queryProductByCId(Integer.valueOf(cid));
			List<Object> firstIDList = new ArrayList<Object>();
			if (list.size() != 0) {
				for (Product product : list) {
					List<ProductImg> queryProductImgDesc = dao
							.queryProductImgDesc(Integer.valueOf(product
									.getID().toString()));
					BigDecimal firstId = null;
					if (queryProductImgDesc.size() > 0) {
						firstId = queryProductImgDesc.get(0).getID();
						firstIDList.add(firstId);
					} else {
						firstIDList.add(firstId);
					}

				}
			}
			req.setAttribute("firstIDList", firstIDList);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/query.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void product(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pid = req.getParameter("pid");
		try {
			Product p = dao.queryProductById(Integer.valueOf(pid));
			List<ProductImg> queryProductImgDesc = dao
					.queryProductImgDesc(Integer.valueOf(pid));
			BigDecimal firstId = null;
			if (queryProductImgDesc.size() > 0) {
				firstId = queryProductImgDesc.get(0).getID();
			}
			List<ProductImg> imglist = dao
					.queryProductImg(Integer.valueOf(pid));
			List<ProductValue> pvlist = dao.queryProductValueByPID(Integer
					.valueOf(pid));
			req.setAttribute("firstId", firstId);
			req.setAttribute("pvlist", pvlist);
			req.setAttribute("imglist", imglist);
			req.setAttribute("p", p);
			req.getRequestDispatcher("/details.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void search(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String content = req.getParameter("content");
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
		try {
			List<Product> list = dao.likeQueryProduct(content);
			List<Object> firstIDList = new ArrayList<Object>();
			if (list.size() != 0) {
				for (Product product : list) {
					List<ProductImg> queryProductImgDesc = dao
							.queryProductImgDesc(Integer.valueOf(product
									.getID().toString()));
					BigDecimal firstId = null;
					if (queryProductImgDesc.size() > 0) {
						firstId = queryProductImgDesc.get(0).getID();
						firstIDList.add(firstId);
					} else {
						firstIDList.add(firstId);
					}

				}
			}
			req.setAttribute("firstIDList", firstIDList);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/query.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
