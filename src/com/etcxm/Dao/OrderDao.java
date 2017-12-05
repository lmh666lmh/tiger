package com.etcxm.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.etcxm.Entity.Order1;
import com.etcxm.Utils.DBUtil;
import com.etcxm.Utils.JDBCUtils;
import com.etcxm.Utils.StringToDate;



public class OrderDao {
	JDBCUtils utils = new JDBCUtils();
	DBUtil dbUtil = new DBUtil();

	public OrderDao() {
		utils.getConnection();
		dbUtil.getConn();
	}
	
	// 查找 所有
		public List<Order1> showAllOrder() throws Exception {
			String sql = "SELECT * FROM VIEW_OD";
			ResultSet rs = dbUtil.Query(sql);
			System.out.println(rs+"resultSet");
			
			
			List<Order1> list = new ArrayList<Order1>(); 
			// 遍历ResultSet中的每条数据    
		    while (rs.next())   
		    {    
		        Order1 od = new Order1();
		        od.setID(rs.getBigDecimal("ID"));
		        od.setCREATEDATE(StringToDate.toSqlTimestamp(rs.getString("CREATEDATE")));
		    	od.setORDERCODE(rs.getString("ORDERCODE"));
		    	od.setADDRESS(rs.getString("ADDRESS"));
		    	od.setPRODUCT_ID(rs.getBigDecimal("PRODUCT_ID"));
		    	od.setPRICE(rs.getBigDecimal("PRICE"));
		    	od.setNUM(rs.getBigDecimal("NUM"));
		    	od.setTITLE(rs.getString("TITLE"));
		    	od.setDISCOUNTPRICE(rs.getBigDecimal("DISCOUNTPRICE"));
		    	list.add(od);
		    }    
		       
			
			utils.releaseConn();
			return list;
		}
}
