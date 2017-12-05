
package com.etcxm.Dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.etcxm.Entity.Category;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductImg;
import com.etcxm.Entity.Shoppingent;
import com.etcxm.Entity.User;
import com.etcxm.Entity.orderItem;
import com.etcxm.Dao.UserDao;

public class DaoTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CartDao dao=new CartDao();
		List<orderItem> list = dao.queryOrderItemByPIDAndUID(2, BigDecimal.valueOf(31));
		System.out.println(list);
	}
}
