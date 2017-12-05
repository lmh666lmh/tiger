package com.etcxm.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.etcxm.Dao.CartDao;
import com.etcxm.Dao.ProductDao;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductImg;
import com.etcxm.Entity.User;
import com.etcxm.Entity.orderItem;
import com.etcxm.Utils.StringUtil;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CartDao dao = new CartDao();
	private ProductDao dao1 = new ProductDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");

		String cmd = req.getParameter("cmd");
		if (StringUtil.hasLength(cmd)) {
			if (cmd.equals("addCart")) {
				addCart(req, resp);
			} else if (cmd.equals("showCart")) {
				showCart(req, resp);
			} else if (cmd.equals("updateCart")) {
				updateCart(req, resp);
			}else if (cmd.equals("deleteCart")) {
				deleteCart(req, resp);
			}
		}

	}

	protected void addCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pid = req.getParameter("pid");
		String num = req.getParameter("num");
		User user = (User) req.getSession().getAttribute("CURRENT_USER");
		BigDecimal uid = user.getID();
		orderItem oi = new orderItem();
		oi.setNUM(BigDecimal.valueOf(Long.valueOf(num)));
		oi.setPID(BigDecimal.valueOf(Long.valueOf(pid)));
		oi.setUSERID(uid);
		List<Product> plist = new ArrayList<Product>();
		List<BigDecimal> imglist = new ArrayList<BigDecimal>();
		try {

			List<orderItem> queryOrderItemByPIDAndUID = dao
					.queryOrderItemByPIDAndUID(Integer.valueOf(pid), uid);
			System.out.println(queryOrderItemByPIDAndUID.size());
			if (queryOrderItemByPIDAndUID.size()<= 0) {
				boolean result = dao.addOrderItem(oi);
				if (result) {
					System.out.println("插入orderItem成功");
					List<orderItem> list = dao.queryOrderItemByUID(uid);

					for (orderItem orderItem : list) {
						Product p = dao1.queryProductById(Integer
								.valueOf(orderItem.getPID().toString()));
						// 获得图片
						List<ProductImg> tmplist = dao1
								.queryProductImgDesc(Integer.valueOf(orderItem
										.getPID().toString()));
						if (tmplist.size() > 0) {
							imglist.add(tmplist.get(0).getID());
						}
						plist.add(p);
					}
					req.setAttribute("imglist", imglist);
					req.setAttribute("list", list);
					req.setAttribute("plist", plist);
					req.getRequestDispatcher("/order/shoppingCart.jsp")
							.forward(req, resp);
				}
			} else {
				boolean result = dao.updateOrderItem(oi);
				if (result) {
					System.out.println("更新orderItem成功");
					List<orderItem> list = dao.queryOrderItemByUID(uid);
					for (orderItem orderItem : list) {
						Product p = dao1.queryProductById(Integer
								.valueOf(orderItem.getPID().toString()));
						// 获得图片
						List<ProductImg> tmplist = dao1
								.queryProductImgDesc(Integer.valueOf(orderItem
										.getPID().toString()));
						if (tmplist.size() > 0) {
							imglist.add(tmplist.get(0).getID());
						}
						plist.add(p);
					}
					req.setAttribute("imglist", imglist);
					req.setAttribute("list", list);
					System.out.println(list);
					req.setAttribute("plist", plist);
					req.getRequestDispatcher("/order/shoppingCart.jsp")
							.forward(req, resp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void showCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("CURRENT_USER");
		BigDecimal uid = user.getID();
		List<Product> plist = new ArrayList<Product>();
		List<BigDecimal> imglist = new ArrayList<BigDecimal>();
		List<orderItem> list;
		try {
			list = dao.queryOrderItemByUID(uid);
			for (orderItem orderItem : list) {
				Product p = dao1.queryProductById(Integer.valueOf(orderItem
						.getPID().toString()));
				// 获得图片
				List<ProductImg> tmplist = dao1.queryProductImgDesc(Integer
						.valueOf(orderItem.getPID().toString()));
				if (tmplist.size() > 0) {
					imglist.add(tmplist.get(0).getID());
				}
				plist.add(p);
			}
			req.setAttribute("imglist", imglist);
			req.setAttribute("list", list);
			req.setAttribute("plist", plist);
			req.getRequestDispatcher("/order/shoppingCart.jsp").forward(req,
					resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void updateCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		String pid = req.getParameter("pid");
		User user = (User) req.getSession().getAttribute("CURRENT_USER");
		BigDecimal uid = user.getID();
		orderItem oi = new orderItem();
		oi.setNUM(BigDecimal.valueOf(Long.valueOf(num)));
		oi.setPID(BigDecimal.valueOf(Long.valueOf(pid)));
		oi.setUSERID(uid);
		try {
			boolean result = dao.updateOrderItemAjax(oi);
			if(result){
				System.out.println("更新购物车成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void deleteCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pid = req.getParameter("pid");
		User user = (User) req.getSession().getAttribute("CURRENT_USER");
		BigDecimal uid = user.getID();
		orderItem oi = new orderItem();
		oi.setPID(BigDecimal.valueOf(Long.valueOf(pid)));
		oi.setUSERID(uid);
		try {
			boolean result = dao.deleteOrderItem(oi);
			if(result){
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
