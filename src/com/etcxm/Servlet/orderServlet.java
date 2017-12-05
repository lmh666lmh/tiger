package com.etcxm.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.Dao.CartDao;
import com.etcxm.Dao.ProductDao;
import com.etcxm.Entity.Order;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductImg;
import com.etcxm.Entity.User;
import com.etcxm.Entity.orderItem;
import com.etcxm.Utils.StringUtil;

@WebServlet("/order")
public class orderServlet extends HttpServlet {

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
			if (cmd.equals("showOrder")) {
				showOrder(req, resp);
			}else if(cmd.equals("addOrder")){
				addOrder(req, resp);
			}
		}
	}

	protected void showOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pidArr = req.getParameter("pidArr");
		String[] pa = pidArr.split(",");
		User user = (User) req.getSession().getAttribute("CURRENT_USER");
		BigDecimal uid = user.getID();
		List<orderItem> list = new ArrayList<orderItem>();
		List<Product> plist = new ArrayList<Product>();
		List<BigDecimal> imglist = new ArrayList<BigDecimal>();
		try {
			for (String s : pa) {
				 orderItem orderItem = dao.SingleOrderItemByPIDAndUID(Integer.valueOf(s), uid);
				 list.add(orderItem);
			}
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
			req.setAttribute("pidArr",pidArr);
			req.setAttribute("imglist", imglist);
			req.setAttribute("list", list);
			req.setAttribute("plist", plist);
			req.getRequestDispatcher("/order/order.jsp").forward(req,
					resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void addOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pidArr = req.getParameter("pidArr");
		String[] pa = pidArr.split(",");
		String totalPay = req.getParameter("totalPay");
		System.out.println(totalPay);
		String address = req.getParameter("address");
		String post = req.getParameter("post");
		String receiver = req.getParameter("receiver");
		String mobile = req.getParameter("mobile");
		String userMessage = req.getParameter("userMessage");
		User user = (User) req.getSession().getAttribute("CURRENT_USER");
		BigDecimal uid = user.getID();
		String code=UUID.randomUUID().toString().replaceAll("-", "");
		Order order=new Order();
		order.setADDRESS(address);
		order.setORDERCODE(code);
		order.setPOST(post);
		order.setMOBILE(mobile);
		order.setSTATUS("waitPay");
		order.setRECEVIER(receiver);
		order.setUSERMESSAGE(userMessage);
	    order.setUSERID(uid);
	    order.setCREATEDATE(new java.sql.Timestamp(new Date().getTime()));
	    try {
			boolean result = dao.addOrder(order);
			if(result){
				System.out.println("创建订单成功");
				BigDecimal oid = dao.queryOrderByCode(code);
				
				for (String s : pa) {
					  orderItem item = dao.SingleOrderItemByPIDAndUID(Integer.valueOf(s), uid);
					boolean updateResult = dao.updateOrderItemOID(oid, item.getID());
			       if(updateResult){
			    	   System.out.println("更新OID成功");
			    	   req.setAttribute("totalPay", totalPay);
						req.getRequestDispatcher("/order/payPage.jsp").forward(req, resp);
			       }
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void showOrder2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
}
